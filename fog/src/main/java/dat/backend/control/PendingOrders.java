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

            Orders pendingOrder = AdminFacade.getOrdersById(idOrders, "new_pending", connectionPool);
            session.setAttribute("pendingOrder", pendingOrder);




            request.getRequestDispatcher("WEB-INF/pendingOrders.jsp").forward(request, response);

        } catch (DatabaseException e)
        {
            e.printStackTrace();
        }

    }
}
