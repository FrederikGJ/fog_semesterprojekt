package dat.backend.control;

import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.entities.entities.User;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.ConnectionPool;
import dat.backend.model.entities.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "signup", value = "/signup")
public class SignUp extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "0";

        try {
            User user = UserFacade.createUser(username, password, role, connectionPool);
            session.setAttribute("user", user); // adding user object to session scope

        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}

