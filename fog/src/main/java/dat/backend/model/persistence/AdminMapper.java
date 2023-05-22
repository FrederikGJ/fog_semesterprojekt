package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Materials;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminMapper {

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

    public static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
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

    public static void editInventory(int idMaterials, String name, int unitPrice, String unit, String description, int length, ConnectionPool connectionPool) throws DatabaseException, SQLException {

        String sql = "UPDATE fog.materials  set material_name =?, unitprice =?,unit=?, description =?, length=? WHERE idmaterials=?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, unitPrice);
                ps.setString(3, unit);
                ps.setString(4, description);
                ps.setInt(5,length);
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
}
