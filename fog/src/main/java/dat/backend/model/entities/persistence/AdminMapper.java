package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMapper {

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
                    int idOrders = rs.getInt("idorders");
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    String comments = rs.getString("comments");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username, comments);
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
                    int idOrders = rs.getInt("idorders");
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    String comments = rs.getString("comments");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username, comments);
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
                    int idOrders = rs.getInt("idorders");
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    String comments = rs.getString("comments");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username, comments);
                    ongoingOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return ongoingOrders;
    }

    static Orders getOrdersById(int idOrders, String status, ConnectionPool connectionPool) throws DatabaseException {
        Orders orders;
        String sql = "";

        switch (status){
            case "new":
               sql = "SELECT * FROM fog.orders WHERE  idorders = ? AND orderstatus = 'New' ORDER BY orderstatus ASC";
               break;
            case "pending":
                sql = "SELECT * FROM fog.orders WHERE  idorders = ? AND orderstatus = 'Pending' ORDER BY orderstatus ASC";
                break;
            case "finished":
                sql = "SELECT * FROM fog.orders WHERE idorders = ? AND orderstatus = 'Finished' ORDER BY orderstatus ASC";
                break;
        }

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, idOrders);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    String comments = rs.getString("comments");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username, comments);
                    return orders;
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return null;
    }


    static List<Orders> getNewOrders (ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> newOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'New'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idOrders = rs.getInt("idorders");
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username);
                    newOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return newOrders;
    }


    static List<Orders> getPendingOrders (ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> pendingOrders = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'Pending'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idOrders = rs.getInt("idorders");
                    String orderStatus = rs.getString("orderstatus");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int totalPrice = rs.getInt("totalprice");
                    String username = rs.getString("username");
                    orders = new Orders(idOrders, orderStatus, length, width, totalPrice, username);
                    pendingOrders.add(orders);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return pendingOrders;
    }



}
