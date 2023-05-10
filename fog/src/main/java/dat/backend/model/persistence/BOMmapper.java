package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BOMmapper {

    static BOM createBOM(int idBOM, int idorders, int quantity, String description, int idvariants,ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, ""); //HVAD GØR LOGGER??
        BOM bom;

        String sql = "insert into fog.BOM (idBOM ,idorders ,quantity, description, idvariants) values (?, ?, ?, ?, ?)";

        try(Connection connection = connectionPool.getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idBOM);
                ps.setInt(2, idorders);
                ps.setInt(3, quantity);
                ps.setString(4, description);
                ps.setInt(5, idvariants);
                int rowsAffected = ps.executeUpdate();


            } catch (SQLException ex) {
                throw new DatabaseException("Denne stykliste kunne ikke skabes id databasen");
            }
        }
        catch (SQLException ex){
            throw new DatabaseException("Denne stykliste kunne ikke skabes id databasen");
        }

        return bom = null; //TROLOLOLO
    }

}
