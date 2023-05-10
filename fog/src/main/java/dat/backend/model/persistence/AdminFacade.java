package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class AdminFacade {
    public static List<Materials> getAllMaterials( int idMaterials,String name, int unitPrice,String unit, String description, ConnectionPool connectionPool) throws DatabaseException {
        return AdminMapper.getAllMaterials(idMaterials, name, unitPrice, unit, description, connectionPool);
    }

}
