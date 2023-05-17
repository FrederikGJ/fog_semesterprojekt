package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
