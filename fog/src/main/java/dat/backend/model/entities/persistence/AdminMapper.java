package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.entities.Orders;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.sql.*;
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

    public static void addToInventory(Materials materials, ConnectionPool connectionPool) throws DatabaseException {

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

    public static void editInventory(int idMaterials, String name, int unitPrice, String unit, String description, int length, ConnectionPool connectionPool) throws DatabaseException, SQLException {

        String sql = "UPDATE fog.materials  set material_name =?, unitprice =?,unit=?, description =?, length=? WHERE idmaterials=?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, unitPrice);
                ps.setString(3, unit);
                ps.setString(4, description);
                ps.setInt(5, length);
                ps.setInt(6, idMaterials);
                ps.executeUpdate();
            } catch (
                    SQLException ex) {
                throw new DatabaseException(ex, "Something went wrong with the database");
            }
        }
    }

    public static void deleteMaterials(int idMaterials, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "DELETE FROM fog.materials WHERE idmaterials =?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idMaterials);
                ps.executeUpdate();
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
    }

    static List<Orders> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {

        List<Orders> ordersList = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Orders orders;

        String sql = "SELECT * FROM fog.orders";

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

        switch (status) {
            case "new_pending":
                sql = "SELECT * FROM fog.orders WHERE  idorders = ? AND orderstatus = 'New' OR orderstatus = 'Pending' ORDER BY orderstatus ASC";
                break;
            case "finished":
                sql = "SELECT * FROM fog.orders WHERE idorders = ? AND orderstatus = 'Finished' ORDER BY orderstatus ASC";
                break;
        }

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idOrders);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
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


    static List<Orders> getNewOrders(ConnectionPool connectionPool) throws DatabaseException {

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


    static List<Orders> getPendingOrders(ConnectionPool connectionPool) throws DatabaseException {

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

    public static void deleteOrders(int idOrders, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "START TRANSACTION; DELETE FROM fog.BOM WHERE idorders = ?; DELETE FROM fog.orders WHERE idorders = ?; COMMIT;"; //FREDERIKS IDE
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idOrders);
                ps.setInt(1, idOrders);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
    }
}
