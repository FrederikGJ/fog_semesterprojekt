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
            case "new_pending":
               sql = "SELECT * FROM fog.orders WHERE  idorders = ? AND orderstatus = 'New' OR orderstatus = 'Pending' ORDER BY orderstatus ASC";
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

}
