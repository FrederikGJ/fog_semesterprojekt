package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;

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
