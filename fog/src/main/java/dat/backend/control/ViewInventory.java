package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.AdminMapper;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "viewinventory", urlPatterns = {"/viewinventory"})

public class ViewInventory extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            try {
                List<Materials> materialsList = AdminFacade.getAllMaterials(connectionPool);
                session.setAttribute("materialsList", materialsList); // adding inventory list object to session scope
                request.getRequestDispatcher("WEB-INF/viewInventory.jsp").forward(request, response);

            } catch (DatabaseException e) {
                request.setAttribute("errormessage", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}










