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

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    name = rs.getString("name");
                    unitPrice = rs.getInt("unitprice");
                    unit = rs.getString("unit");
                    description = rs.getString("description");
                   Materials materials = new Materials(name, unitPrice, unit, description );
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

        String sql = "SELECT * FROM fog.orders WHERE orderstatus = 'New' OR orderstatus = 'Pending'";

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
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return ongoingOrders;
    }


}
