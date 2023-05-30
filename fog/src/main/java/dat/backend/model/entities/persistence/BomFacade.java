package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.util.ArrayList;
import java.util.List;

public class BomFacade {


    public static ArrayList<BOM> getBOMById(int idorders, ConnectionPool connectionPool) throws DatabaseException {
        return BomMapper.getBOMById(idorders, connectionPool);
    }

    public static void createBOM(Orders order, Materials material, String descriptionOfUSe,
                                 int quantity, ConnectionPool connectionPool) throws DatabaseException {
        BomMapper.createBOM(order, material, descriptionOfUSe, quantity, connectionPool);

    }

    public static ArrayList<BOM> readBOM(ConnectionPool connectionPool) throws DatabaseException {
        return BomMapper.readBOM(connectionPool);
    }

    public static List<Integer> getIdOrdersFromBom(ConnectionPool connectionPool) throws DatabaseException {
        return BomMapper.getIdOrdersFromBom(connectionPool);
    }

}
