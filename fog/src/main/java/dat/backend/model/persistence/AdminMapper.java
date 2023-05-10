package dat.backend.model.persistence;

import dat.backend.model.entities.Materials;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMapper {

    static List<Materials> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        List<Materials> materialsList = new ArrayList<>();
        //Logger.getLogger("web").log(Level.INFO, "");
        Materials materials;

        String sql = "SELECT * FROM fog.materials";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idMaterials = rs.getInt("idmaterials");
                    String name = rs.getString("material_name");
                    int unitPrice = rs.getInt("unitprice");
                    String unit = rs.getString("unit");
                    String description = rs.getString("description");
                    materials = new Materials(idMaterials, name, unitPrice, unit, description);
                    materialsList.add(materials);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return materialsList;
    }

}
