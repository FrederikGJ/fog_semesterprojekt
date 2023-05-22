package dat.backend.control;

import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.AdminFacade;
import dat.backend.model.entities.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewOrders", value = "/ViewOrders")
public class ViewOrders extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try{
            List<Orders> newOrders = AdminFacade.getNewOrders(connectionPool);
            session.setAttribute("newOrders", newOrders);

            List<Orders> pendingOrders = AdminFacade.getPendingOrders(connectionPool);
            session.setAttribute("pendingOrders", pendingOrders);

            List<Orders> finishedOrders = AdminFacade.getFinishedOrders(connectionPool);
            session.setAttribute("finishedOrders", finishedOrders);

            request.getRequestDispatcher("WEB-INF/viewOrders.jsp").forward(request, response);

        } catch(DatabaseException e){
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }




        /*try {
            List<Orders> ordersList = OrdersFacade.getAllOrders(connectionPool); // Henter alle ordre fra databasen, tilføjer og gemmer dem i en ArrayListe
            Map<Integer, Orders> ordersMap = new HashMap<>();

            for (Orders orders : ordersList) { // Iterer igennem ordersList
                ordersMap.put(orders.getIdorders(), orders); // Tilføjer og gemmer listen af ordre i et ordersMap
                request.getSession().setAttribute("ordersMap", ordersMap); // Gemmer ordersMap i session scope
            }
            request.setAttribute("ordersList", ordersList);



            request.getRequestDispatcher("WEB-INF/viewOrders.jsp").forward(request, response);
        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }*/




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
