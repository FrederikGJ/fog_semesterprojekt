package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.util.ArrayList;

public class BomFacade {


    public static ArrayList<BOM> getBOMById(int idorders, ConnectionPool connectionPool)throws DatabaseException{
        return BomMapper.getBOMById(idorders, connectionPool);
    }

    public static BOM createBOM(Orders order, Materials material, String descriptionOfUSe,
                                int quantity, ConnectionPool connectionPool) throws DatabaseException {
        return BomMapper.createBOM(order, material, descriptionOfUSe, quantity, connectionPool);

    }

    public static ArrayList<BOM> readBOM(ConnectionPool connectionPool)throws DatabaseException{
        return BomMapper.readBOM(connectionPool);
    }

}
