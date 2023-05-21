package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CalculateBOM;
import dat.backend.model.entities.ListOfOrders;
import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrdersFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmCarport", value = "/ConfirmCarport")
public class ConfirmCarport extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        User user = (User) session.getAttribute("user"); // Henter user ud fra session scope
        String username = user.getUsername();
        String comment = request.getParameter("comment");


        try {
            OrdersFacade.createOrder( width, length, username, comment, connectionPool);
            Orders order = new Orders(width, length, username, comment);
            ListOfOrders orderList = new ListOfOrders();
            orderList.add(order);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
