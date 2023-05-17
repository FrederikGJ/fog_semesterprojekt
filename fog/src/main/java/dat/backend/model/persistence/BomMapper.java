package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomMapper {

    static BOM createBOM(Orders order, Materials material, String descriptionOfUSe,
                         int quantity, Materials materials, ConnectionPool connectionPool) throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        // The logger is used for monitoring
        // the behavior of the application, troubleshooting problems, and auditing purposes.
        BOM bom;
        String sql = "insert into fog.BOM (idorders, quantity, description, idmaterials) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order.getIdorders());
                ps.setInt(2, quantity);
                ps.setString(3, descriptionOfUSe);
                ps.setInt(4, material.getIdmaterials());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    bom = new BOM( materials, descriptionOfUSe, quantity);
                } else {
                    throw new DatabaseException("The BOM with idorders = " + order.getIdorders() + " and descrition"
                            + descriptionOfUSe + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert BOM into database");
        }
     return bom;
    }

    static ArrayList<BOM> readBOM(ConnectionPool connectionPool) throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        BOM bom;
        //********************************
        String sql = "SELECT * FROM fog.BOM";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    //TODO get material name and add it
                    bom = new BOM(rs.getInt(4), rs.getString(3), rs.getInt(2));
                    bomArrayList.add(bom);
                } else {
                    throw new DatabaseException("Something went wrong when reading BOM list");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database when you tried to read BOM");
        }

        return bomArrayList;
    }


}
