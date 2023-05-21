package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BOM;
import dat.backend.model.entities.CalculateBOM;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "makeoffer", value = "/makeoffer")
public class MakeOffer extends HttpServlet
{
    private ConnectionPool connectionPool;

    public void init()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try{


            int idOrders  = Integer.parseInt(request.getParameter("idOrders"));
            session.setAttribute("idOrders", idOrders);

            Orders ongoingOrder = AdminFacade.getOrdersById(idOrders, "new_pending", connectionPool);
            session.setAttribute("ongoingOrder", ongoingOrder);

            ArrayList<BOM> bomArrayList = BomFacade.getBOMById(idOrders, connectionPool);
            session.setAttribute("bomArrayList", bomArrayList);



            CalculateBOM calBom = new CalculateBOM();

//          double totalBomPrice = 10891.80;

            //createCarport skal vel ske når man bekræfter sin bestilling?
            //calBom.createCarportBOM(ongoingOrder, ongoingOrder.getLength(), ongoingOrder.getWidth(), connectionPool);
            double totalBomPrice = calBom.bomPrice(ongoingOrder);
            session.setAttribute("totalBomPrice", totalBomPrice);



            //calculation of operation margin (dækningsgraden - fortjenesten i % af salgsprisen)
            //dækningsgrad = dækningsbidrag x 100 / salgspris
            //dækningsbidrag: salgspris - kostpris



            //automatisk dækningsgrad
            double autoOperationMargin = 39.02;


            double autoSalesprice = Math.round(totalBomPrice/(1-(autoOperationMargin/100))*1.25);
            session.setAttribute("autoSalesprice", autoSalesprice);

            //skal kigges på til vejledning
//            double salesprice = Double.parseDouble(request.getParameter("salesprice"));
//            session.setAttribute("salesprice", salesprice);

            double salespriceTaxFree = Math.round(autoSalesprice/1.25);
            session.setAttribute("salespriceTaxFree", salespriceTaxFree);

            Orders orders = new Orders();

            //dækningsbidrag
            double grossProfit = Math.round(orders.makeGrossProfit(salespriceTaxFree, totalBomPrice));
            session.setAttribute("grossProfit", grossProfit);

            //dækningsgraden
            double operationMargin = Math.round(orders.makeOperationMargin(grossProfit, salespriceTaxFree));
            session.setAttribute("operationMargin", operationMargin);


            //lavet funktioner til udregning inde i klassen Orders, giver det mening eller skal det ligge et andet sted?


            // lav egen jsp og servlet til finishedOrder i stedet for MakeOffer
            // Orders finishedOrder = AdminFacade.getOrdersById(idorders, "finished", connectionPool);
            // session.setAttribute("finishedOrder", finishedOrder);

            request.getRequestDispatcher("WEB-INF/makeOffer.jsp").forward(request, response);

        } catch(DatabaseException e){
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }


}
