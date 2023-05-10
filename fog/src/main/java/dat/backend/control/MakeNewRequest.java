package dat.backend.control;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.OrdersFacade;
import dat.backend.model.persistence.OrdersMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MakeNewRequest", value = "/MakeNewRequest")
public class MakeNewRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session = request.getSession();
        request.getRequestDispatcher("WEB-INF/orderNewCarport.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));


        /* try {
            OrdersFacade.createOrder(1,width, length, 0, user);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        session.setAttribute("order", order); // Gemmer her den nye "fyldte" indkøbskurv på session scope// Gemmer den totale pris for indkøbskurvens inhold på session scope
        */
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response); // Giver kunderne mulighed for at shoppe videre

    }
}
