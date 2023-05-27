package dat.backend.control;


import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.AdminFacade;
import dat.backend.model.entities.persistence.ConnectionPool;
import dat.backend.model.entities.persistence.OrdersFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "acceptcarport", value = "/acceptcarport")
public class AcceptCarport extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");

        try{

            int idOrders = Integer.parseInt(request.getParameter("idOrders"));

            Orders pendingOrder = AdminFacade.getOrdersById(idOrders, "pending", connectionPool);
            session.setAttribute("pendingOrders ", pendingOrder);

            String newOrderStatus = pendingOrder.getOrderStatus();
            session.setAttribute("newOrderStatus", newOrderStatus);
            newOrderStatus = "Finished";

            OrdersFacade.updateOrder(newOrderStatus,pendingOrder.getTotalPrice(), pendingOrder.getComments(), pendingOrder.getIdOrders(), connectionPool);

            request.getRequestDispatcher("WEB-INF/confirmPurchase.jsp").forward(request, response);

        }catch (DatabaseException e) {
           request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }



    }

