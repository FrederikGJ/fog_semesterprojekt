package dat.backend.control;

import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.CalculateBOM;
import dat.backend.model.entities.entities.Materials;
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

@WebServlet(name = "viewbom", value = "/viewbom")
public class ViewBOM extends HttpServlet
{
    private ConnectionPool connectionPool;

    public void init()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try{

            int idOrders  = Integer.parseInt(request.getParameter("idOrders"));
            session.setAttribute("idOrders", idOrders);

            Orders ongoingOrder = AdminFacade.getOrdersById(idOrders, "new", connectionPool);
            session.setAttribute("ongoingOrder", ongoingOrder);


            List<Integer> listOfIdOrders = BomFacade.getIdOrdersFromBom(connectionPool);

            CalculateBOM calBom = new CalculateBOM();

            //if the current order already exits in the database, it will not be added again.
            if(!listOfIdOrders.contains(idOrders))
            {
                calBom.createCarportBOM(ongoingOrder, ongoingOrder.getLength(), ongoingOrder.getWidth(), connectionPool);
                ArrayList<BOM> bomArrayList = BomFacade.getBOMById(idOrders, connectionPool);
                session.setAttribute("bomArrayList", bomArrayList);
            }

            ArrayList<BOM> bomArrayList = BomFacade.getBOMById(idOrders, connectionPool);
            session.setAttribute("bomArrayList", bomArrayList);


            double totalBomPrice = 0;
            for (BOM bom : bomArrayList) {
                if(idOrders == bom.getIdOrders()){
                    totalBomPrice = calBom.bomPrice(ongoingOrder, idOrders);
                    session.setAttribute("totalBomPrice", totalBomPrice);
                }
            }

            request.getRequestDispatcher("WEB-INF/viewBOM.jsp").forward(request, response);

        } catch(DatabaseException e){
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }


}
