package dat.backend.control;

import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.AdminFacade;
import dat.backend.model.entities.persistence.BomFacade;
import dat.backend.model.entities.persistence.ConnectionPool;

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



            //CalculateBOM calBom = new CalculateBOM();

            double totalBomPrice = 10891.80;

            //createCarport skal vel ske når man bekræfter sin bestilling?
            //calBom.createCarportBOM(ongoingOrder, ongoingOrder.getLength(), ongoingOrder.getWidth(), connectionPool);
            //double totalBomPrice = calBom.bomPrice(ongoingOrder);
            session.setAttribute("totalBomPrice", totalBomPrice);


            //calculation of operation margin (dækningsgraden - fortjenesten i % af salgsprisen)
            //dækningsgrad = dækningsbidrag x 100 / salgspris
            //dækningsbidrag: salgspris - kostpris


            //automatisk dækningsgrad
            double autoOperationMargin = 39.02;


            double autoSalesprice = Math.round(totalBomPrice/(1-(autoOperationMargin/100))*1.25);
            session.setAttribute("autoSalesprice", autoSalesprice);

            String salespriceString = request.getParameter("salesprice");
            double salesprice = autoSalesprice;
            if (salespriceString != null)
            {
                salesprice = Double.parseDouble(salespriceString);
            }
            session.setAttribute("salesprice", salesprice);


            double salespriceTaxFree = salesprice/1.25;
            String salesPriceTaxFreeTwoDecimals = String.format("%.2f", salespriceTaxFree);
            session.setAttribute("salespriceTaxFree", salesPriceTaxFreeTwoDecimals);

            Orders orders = new Orders();

            //dækningsbidrag
            double grossProfit = orders.makeGrossProfit(salespriceTaxFree, totalBomPrice);
            String grossProfitTwoDecimals = String.format("%.2f", grossProfit);
            session.setAttribute("grossProfit", grossProfitTwoDecimals);

            //dækningsgraden
            double operationMargin = orders.makeOperationMargin(grossProfit, salespriceTaxFree);
            String operationMarginTwoDecimals = String.format("%.2f", operationMargin);
            session.setAttribute("operationMargin", operationMarginTwoDecimals);

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
