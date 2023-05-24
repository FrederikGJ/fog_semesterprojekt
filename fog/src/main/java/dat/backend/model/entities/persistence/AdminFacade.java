package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.List;

public class AdminFacade {

    public static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getAllMaterials(connectionPool);
    }

    public static void addToInventory(Materials materials, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper.addToInventory(materials, connectionPool);
    }

    public static void deleteMaterials(int idMaterials,  ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper.deleteMaterials(idMaterials, connectionPool);
    }

    public static void editMaterials(int idMaterials,String name, int unitPrice, String unit, String description, int length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        AdminMapper.editInventory(idMaterials, name, unitPrice, unit, description, length, connectionPool);

    }
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

    public static Orders getOrdersById(int idOrders, String status, ConnectionPool connectionPool) throws DatabaseException
    {
        return AdminMapper.getOrdersById(idOrders, status, connectionPool);
    }

    public static void deleteOrders(int idOrders, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper.deleteOrders(idOrders,connectionPool);
    }
}
