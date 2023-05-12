package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersMapper {
    static void createOrder(int orderstatus, int width, int length, String username, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;
        int def = 0;
        String sql = "insert into fog.orders (orderstatus, length, width, totalprice, username) values (?,?,?,?,?);";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderstatus);
                ps.setInt(2, length);
                ps.setInt(3, width);
                ps.setInt(4, def);
                ps.setString(5, username);


                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static int createIdOrders(ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT * FROM orders WHERE idOrders = ? ";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys(); // Da idorders ikke eksisterer endnu gennereres det automatisk
                rs.next();
                ps.executeUpdate();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "fejl");
        }
    }


}
