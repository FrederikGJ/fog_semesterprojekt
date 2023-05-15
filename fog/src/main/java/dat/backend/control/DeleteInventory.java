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
    Materials materials;


    @Override
    public void init() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Materials> materialsList = (List<Materials>) session.getAttribute("materialsList"); // adding inventory list object to session scope

        try {
            int idMaterials = Integer.parseInt(request.getParameter("idmaterials1"));
            AdminFacade.deleteMaterials(materials, connectionPool);
            request.setAttribute("idmaterials", materials.getIdMaterials());
            materialsList.remove("");
            //slet fra arraylisten
            request.getRequestDispatcher("WEB-INF/viewInventory.jsp").forward(request, response);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
