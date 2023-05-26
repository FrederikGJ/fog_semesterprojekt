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

@WebServlet(name = "sendoffer", value = "/sendoffer")
public class SendOffer extends HttpServlet
{

    private ConnectionPool connectionPool;

    public void init(){
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        try{

            int idOrders = (int) session.getAttribute("idOrders");

            Orders ongoingOrder = AdminFacade.getOrdersById(idOrders, "new", connectionPool);
            session.setAttribute("ongoingOrder", ongoingOrder);

            //changing orderstatus from new to pending
            String newOrderStatus = ongoingOrder.getOrderStatus();
            session.setAttribute("newOrderStatus", newOrderStatus);
            newOrderStatus = "Pending";


            double salesprice = (double) session.getAttribute("salesprice");
            session.setAttribute("salesprice", salesprice);


            String customerComment = ongoingOrder.getComments();

            String adminComment = request.getParameter("adminComment");
            request.setAttribute("adminComment", adminComment);

            String totalComments = customerComment + ". " + adminComment;

            OrdersFacade.updateOrder(newOrderStatus, salesprice, totalComments, idOrders, connectionPool);


            request.getRequestDispatcher("WEB-INF/sendOffer.jsp").forward(request, response);

        }catch(DatabaseException e){
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

}
