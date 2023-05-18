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

    public static List<Orders> getNewOrders(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getNewOrders(connectionPool);
    }

    public static List<Orders> getPendingOrders(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getPendingOrders(connectionPool);
    }


    public static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getAllMaterials(connectionPool);
    }

    public static Orders getOrdersById(int idOrders, String status, ConnectionPool connectionPool) throws DatabaseException
    {
        return AdminMapper.getOrdersById(idOrders, status, connectionPool);
    }


}
