package dat.backend.control;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.AdminMapper;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.text.Collator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "viewrequests", value = "/viewrequests")
public class ViewRequests extends HttpServlet{

    private ConnectionPool connectionPool;

    public void init(){
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try{
            List<Orders> ongoingOrders = AdminFacade.getOngoingOrders(connectionPool);
            session.setAttribute("ongoingOrders", ongoingOrders);

            List<Orders> finishedOrders = AdminFacade.getFinishedOrders(connectionPool);
            session.setAttribute("finishedOrders", finishedOrders);

            request.getRequestDispatcher("WEB-INF/viewRequests.jsp").forward(request, response);

        } catch(DatabaseException e){
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
