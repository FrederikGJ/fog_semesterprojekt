package dat.backend.control;

import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.CalculateBOM;
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
import java.util.List;

@WebServlet(name = "pendingorders", value = "/pendingorders")
public class PendingOrders extends HttpServlet
{
    private ConnectionPool connectionPool;

    public void init(){
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try
        {
            int idOrders = Integer.parseInt(request.getParameter("idOrders"));
            session.setAttribute("idOrders", idOrders);

            Orders pendingOrder = AdminFacade.getOrdersById(idOrders, "pending", connectionPool);
            session.setAttribute("pendingOrder", pendingOrder);

            List<Integer> listOfIdOrders = BomFacade.getIdOrdersFromBom(connectionPool);

            CalculateBOM calBom = new CalculateBOM();

            //if the current order already exits in the database, it will not be added again.
            if(!listOfIdOrders.contains(idOrders))
            {
                calBom.createCarportBOM(pendingOrder, pendingOrder.getLength(), pendingOrder.getWidth(), connectionPool);
                ArrayList<BOM> bomArrayList = BomFacade.getBOMById(idOrders, connectionPool);
                session.setAttribute("bomArrayList", bomArrayList);
            }

            ArrayList<BOM> bomArrayList = BomFacade.getBOMById(idOrders, connectionPool);
            session.setAttribute("bomArrayList", bomArrayList);


            double totalBomPrice = 10891.80;

            //double totalBomPrice = calBom.bomPrice(ongoingOrder);
            session.setAttribute("totalBomPrice", totalBomPrice);


            double autoOperationMargin = 39.02;

            double autoSalesprice = Math.round(totalBomPrice/(1-(autoOperationMargin/100))*1.25);
            session.setAttribute("autoSalesprice", autoSalesprice);

            double salesprice = pendingOrder.getTotalPrice();

            double salespriceTaxFree = salesprice/1.25;
            String salesPriceTaxFreeTwoDecimals = String.format("%.2f", salespriceTaxFree);
            session.setAttribute("salespriceTaxFree", salesPriceTaxFreeTwoDecimals);

            Orders orders = new Orders();

            //price change from autoSalesprice with operationMargin on 39.02 to new salesprice.
            double priceChange = salesprice - autoSalesprice;
            String priceChangeTwoDecimals = String.format("%.2f", priceChange);
            session.setAttribute("priceChange", priceChangeTwoDecimals);

            //dækningsbidrag
            double grossProfit = orders.makeGrossProfit(salespriceTaxFree, totalBomPrice);
            String grossProfitTwoDecimals = String.format("%.2f", grossProfit);
            session.setAttribute("grossProfit", grossProfitTwoDecimals);

            //dækningsgraden
            double operationMargin = orders.makeOperationMargin(grossProfit, salespriceTaxFree);
            String operationMarginTwoDecimals = String.format("%.2f", operationMargin);
            session.setAttribute("operationMargin", operationMarginTwoDecimals);


            request.getRequestDispatcher("WEB-INF/pendingOrders.jsp").forward(request, response);

        } catch (DatabaseException e)
        {
            e.printStackTrace();
        }

    }
}
