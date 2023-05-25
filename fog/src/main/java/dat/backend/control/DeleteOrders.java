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

@WebServlet(name = "deleteorders", value = "/deleteorders")
public class DeleteOrders extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            int idOrders = Integer.parseInt(request.getParameter("idOrdersD"));
            AdminFacade.deleteOrders(idOrders, connectionPool);
            Orders orders = new Orders(idOrders);
            List<Orders> newOrders = AdminFacade.getNewOrders(connectionPool);
            newOrders.remove(orders);
            session.setAttribute("newOrders", newOrders);
            request.setAttribute("msgDelete", "Ordren er blevet slettet fra systemet");

        } catch (DatabaseException e) {
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/viewRequests.jsp").forward(request, response);
    }
}

