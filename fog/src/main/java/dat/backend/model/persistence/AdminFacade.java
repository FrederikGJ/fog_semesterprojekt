package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class AdminFacade {


    public static List<Orders> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getAllOrders(connectionPool);
    }

    public static List<Orders> getFinishedOrders(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getFinishedOrders(connectionPool);
    }

    public static List<Orders> getOngoingOrders(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getOngoingOrders(connectionPool);
    }


}
