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

            int idorders  = Integer.parseInt(request.getParameter("idorders"));
            session.setAttribute("idorders", idorders);

            Orders ongoingOrder = AdminFacade.getOrdersById(idorders, "new_pending", connectionPool);
            session.setAttribute("ongoingOrder", ongoingOrder);

            List<BOM> listBOM = BomFacade.readBOM(connectionPool);
            session.setAttribute("listBOM", listBOM);


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
