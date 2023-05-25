package dat.backend.control;

import dat.backend.model.entities.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MakeNewRequest", value = "/MakeNewRequest")
public class MakeNewRequest extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session = request.getSession();
        request.getRequestDispatcher("WEB-INF/orderNewCarport.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session = request.getSession();

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        String comment = request.getParameter("comment");


        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("comment", comment);
        request.getRequestDispatcher("WEB-INF/confirmCarport.jsp").forward(request, response); // Giver kunderne mulighed for at shoppe videre
    }
}
