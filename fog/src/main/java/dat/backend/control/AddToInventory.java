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

@WebServlet(name = "addtoinventory", value = "/addtoinventory")
public class AddToInventory extends HttpServlet {
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
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
        String unit = request.getParameter("unit");
        String description = request.getParameter("description");
        int length = Integer.parseInt(request.getParameter("length"));
        Materials materials = new Materials(name, unitPrice, unit, description, length); // new materials object to add to list in session scope

        List<Materials> materialsList = (List<Materials>) session.getAttribute("materialsList"); // getting inventory list object to session scope
        materialsList.add(materials);

        try {
            AdminFacade.addToInventory(materials, connectionPool);
            request.setAttribute("material_name", materials.getName());
            request.setAttribute("unitprice", materials.getUnitPrice());
            request.setAttribute("unit", materials.getUnit());
            request.setAttribute("description", materials.getDescription());
            request.setAttribute("length", materials.getLength());
            request.setAttribute("msgAdd", "Vare er blevet tilføjet til inventar");

            request.getRequestDispatcher("WEB-INF/viewInventory.jsp").forward(request, response);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
