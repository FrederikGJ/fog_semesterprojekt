package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomMapper {

    static BOM createBOM(int idBOM, Orders order, Materials material, String descriptionOfUSe, int quantity, Materials materials, ConnectionPool connectionPool) throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        // The logger is used for monitoring
        // the behavior of the application, troubleshooting problems, and auditing purposes.
        BOM bom; 
        String sql = "insert into fog.BOM (idBOM, idorders, quantity, description, idmaterials) values (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idBOM);
                ps.setInt(2, order.getIdorders());
                ps.setInt(3, quantity);
                ps.setString(4, descriptionOfUSe);
                ps.setInt(5, material.getIdmaterials());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    bom = new BOM(idBOM, materials, descriptionOfUSe, quantity);
                } else {
                    throw new DatabaseException("The BOM with idBOM = " + idBOM + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert BOM into database");
        }
     return bom;
    }

    static ArrayList<BOM> readBOM(){
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        BOM bom = null;
        bomArrayList.add(bom);
        return bomArrayList;
    }


}
