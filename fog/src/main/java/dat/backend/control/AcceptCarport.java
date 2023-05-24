package dat.backend.control;


import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.ConnectionPool;
import dat.backend.model.entities.persistence.OrdersFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
       int idOrders = Integer.parseInt(request.getParameter("idOrders"));

        try {
            OrdersFacade.statusFinished(idOrders, connectionPool);
        request.getRequestDispatcher("WEB-INF/confirmPurchase.jsp").forward(request, response);
     } catch (DatabaseException e) {
           e.printStackTrace();
       }
    }
    }

