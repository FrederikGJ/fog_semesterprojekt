package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMapper {

    static List<Materials> getAllMaterials(String name, int unitPrice,String unit, String description,ConnectionPool connectionPool) throws DatabaseException {

        List<Materials> materialsList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM materials";
import dat.backend.model.exceptions.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

     static void addToInventory(Materials materials, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "INSERT INTO fog.materials (material_name, unitprice, unit, description, length) VALUES (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, materials.getName());
                ps.setInt(2, materials.getUnitPrice());
                ps.setString(3, materials.getUnit());
                ps.setString(4, materials.getDescription());
                ps.setInt(5, materials.getLength());
                ps.executeUpdate();

            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
    }

    static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        List<Materials> materialsList = new ArrayList<>();
        String sql = "SELECT * FROM fog.materials";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Materials materials = new Materials(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    materialsList.add(materials);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return materialsList;
    }


    static List<Orders> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> ordersList = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idorders = rs.getInt("idorders");
                    String orderstatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalprice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idorders, orderstatus, length, width, totalprice, username);
                    ordersList.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return ordersList;
    }


    static List<Orders> getFinishedOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> finishedOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'Finished'";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idorders = rs.getInt("idorders");
                    String orderstatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalprice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idorders, orderstatus, length, width, totalprice, username);
                    finishedOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return finishedOrders;
    }


    static List<Orders> getOngoingOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> ongoingOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'New' OR orderstatus = 'Pending' ORDER BY orderstatus ASC";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idorders = rs.getInt("idorders");
                    String orderstatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalprice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idorders, orderstatus, length, width, totalprice, username);
                    ongoingOrders.add(orders);
                }


    static Materials getMaterialsByID(int idMaterials, ConnectionPool connectionPool) throws DatabaseException {
        List<Materials> materialsList = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM fog.materials WHERE idmaterials = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idMaterials);
                ResultSet rs = ps.executeQuery();
                Materials materials = null;
                while (rs.next()) {
                    materials = new Materials(rs.getInt(0), rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                    materialsList.add(materials);
                }
                return materials;
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return ongoingOrders;
    }

    static List<Orders> getNewOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> newOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'New'";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idorders = rs.getInt("idorders");
                    String orderstatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalprice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idorders, orderstatus, length, width, totalprice, username);
                    newOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return newOrders;
    }

    static List<Orders> getPendingOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> pendingOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'Pending'";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int idorders = rs.getInt("idorders");
                    String orderstatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalprice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idorders, orderstatus, length, width, totalprice, username);
                    pendingOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return pendingOrders;
    }





    }

    static void editMaterials(String name, int unitPrice, String unit, String description, int length, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "UPDATE fog.materials set material_name = ?, unitprice = ?, unit= ?, description = ?, length = ?";
        try (
                Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, unitPrice);
                ps.setString(3, unit);
                ps.setString(4, description);
                ps.setInt(5, length);
                ps.executeQuery();
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
    }


    static void deleteMaterials(int idMaterials, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "DELETE fog.materials WHERE idmaterials = ?";
        try (
                Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idMaterials);
                ps.executeUpdate();

            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
    }
}
