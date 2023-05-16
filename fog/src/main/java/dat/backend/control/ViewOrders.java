package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrdersFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ViewOrders", value = "/ViewOrders")
public class ViewOrders extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
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
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
