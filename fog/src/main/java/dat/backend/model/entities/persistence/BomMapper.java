package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.BOM;
import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomMapper
{

    static void createBOM(Orders order, Materials material, String descriptionOfUSe,
                          int quantity, ConnectionPool connectionPool) throws DatabaseException{

        //TODO: Der er noget galt her som gør at DB ikke opdateres

        Logger.getLogger("web").log(Level.INFO, "");

        BOM bom;
        String sql = "insert into fog.BOM (idorders, quantity, description, idmaterials) values (?,?,?,?)";



        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order.getIdOrders());
                ps.setInt(2, quantity);
                ps.setString(3, descriptionOfUSe);
                ps.setInt(4, material.getIdMaterials());
                ps.executeUpdate();
                /*
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    bom = new BOM( material, descriptionOfUSe, quantity);
                } else {
                    throw new DatabaseException("The BOM with idorders = " + order.getIdOrders() + " and descrition"
                            + descriptionOfUSe + " could not be inserted into the database");
                }

                 */
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert BOM into database");
        }
        //return bom;
    }


    static ArrayList<BOM> readBOM(ConnectionPool connectionPool) throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        BOM bom;
        //**
        String sql = "SELECT * FROM fog.BOM";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idmaterials = rs.getInt(4);
                    String description = rs.getString(3);
                    int quantity = rs.getInt(2);
                    bom = new BOM(idmaterials, description, quantity);
                    bomArrayList.add(bom);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database when you tried to read BOM");
        }

        return bomArrayList;
    }


    static ArrayList<BOM> getBOMById(int idOrders, ConnectionPool connectionPool) throws DatabaseException {
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");
        BOM bom;

        String sql = "SELECT * FROM fog.BOM WHERE idorders = ?";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, idOrders);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    String descriptionOfUse = rs.getString("description");
                    int idMaterials = rs.getInt("idmaterials");
                    bom = new BOM(idOrders, quantity, descriptionOfUse, idMaterials);
                    bomArrayList.add(bom);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database when you tried to get BOM via ordersID");
        }
        return bomArrayList;
    }

}