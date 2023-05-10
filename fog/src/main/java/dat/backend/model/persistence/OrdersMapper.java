package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersMapper {
    static Orders createOrder(int orderstatus, int width, int length, int totalprice, User user, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;
        String sql = "insert into fog.orders (orderstatus, width, length, totalprice, user) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(2, orderstatus);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, totalprice);
                ps.setString(6, user.getUsername());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    orders = new Orders (createIdOrders(connectionPool),orderstatus, width, length, totalprice, user);
                } else {
                    throw new DatabaseException("The user with username = " + user.getUsername() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return orders;
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
