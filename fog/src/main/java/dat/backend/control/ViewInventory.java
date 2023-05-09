package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Materials;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "viewinventory", urlPatterns = {"/viewiinventory"})

public class ViewInventory extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        int unitPrice = Integer.parseInt(request.getParameter("unitprice"));
        String unit = request.getParameter("unit");
        String description = request.getParameter("description");

        try {
            List<Materials> materialsList = AdminFacade.getAllMaterials(name, unitPrice, unit, description,connectionPool);
            session.setAttribute("materialsList", materialsList); // adding user object to session scope


        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/welcomeAdmin.jsp").forward(request, response);
    }


}








