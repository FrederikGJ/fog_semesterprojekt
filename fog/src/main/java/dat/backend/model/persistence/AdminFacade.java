package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;

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

}
