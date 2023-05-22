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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "editinventory", value = "/editinventory")
public class EditInventory extends HttpServlet {
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

        String name = request.getParameter("nameE");
        int unitPrice = Integer.parseInt(request.getParameter("unitPriceE"));
        String unit = request.getParameter("unitE");
        String description = request.getParameter("descriptionE");
        int length = Integer.parseInt(request.getParameter("lengthE"));
        int idMaterials = Integer.parseInt(request.getParameter("idMaterialsE"));



        try {
            AdminFacade.editMaterials(idMaterials, name, unitPrice, unit, description, length, connectionPool);
            List<Materials> materialsList = AdminFacade.getAllMaterials(connectionPool);
            session.setAttribute("materialsList", materialsList); // adding inventory list object to session scope

            request.setAttribute("msgEdit", "Vare er blevet ændret i inventar");
            request.getRequestDispatcher("WEB-INF/viewInventory.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}