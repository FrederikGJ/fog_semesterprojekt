package dat.backend.control;



import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.User;
import dat.backend.model.entities.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "welcome", value = "/welcome")
public class Welcome extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user.getRole().equalsIgnoreCase("admin")) {
            session.setAttribute("admin", true); // adding admin object to session scope
            request.getRequestDispatcher("WEB-INF/welcomeAdmin.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}