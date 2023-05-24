package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersMapper {

    List<Orders> ordersList = new ArrayList<>();

    static void createOrder( int width, int length, String username, String comment, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;
        int def = 0;
        String sql = "insert into fog.orders ( length, width, totalprice, username, comments) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, length);
                ps.setInt(2, width);
                ps.setInt(3, def);
                ps.setString(4, username);
                ps.setString(5,comment);
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void statusFinished (int idOrders, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "update  fog.orders set orderstatus =? where idorder=?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, "Finished");
                ps.setInt(2, idOrders);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not change status in database");
        }
    }




}
