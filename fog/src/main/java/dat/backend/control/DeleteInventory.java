package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Materials;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteinventory", value = "/deleteinventory")
public class DeleteInventory extends HttpServlet {
    private ConnectionPool connectionPool;


    @Override
    public void init() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            int idMaterialsD = Integer.parseInt(request.getParameter("idMaterialsD"));
            AdminFacade.deleteMaterials(idMaterialsD, connectionPool);
            Materials materials1 = new Materials(idMaterialsD);// new materials object to add to list in session scope
            List<Materials> materialsList = AdminFacade.getAllMaterials(connectionPool);
            materialsList.remove(materials1);
            session.setAttribute("materialsList", materialsList); // adding inventory list object to session scope
            request.setAttribute("msgDelete", "Vare er blevet slettet fra inventar");
            request.getRequestDispatcher("WEB-INF/viewInventory.jsp").forward(request, response);

        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
