package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class AdminFacade {
    public static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getAllMaterials(connectionPool);
    }

    public static void addToInventory(Materials materials, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper.addToInventory(materials, connectionPool);
    }
}
//String name, int unitPrice, String unit, String description, int length,