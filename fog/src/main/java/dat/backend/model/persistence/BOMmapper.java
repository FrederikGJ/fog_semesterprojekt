package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BOMmapper {

    static BOM createBOM(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, ""); //HVAD GØR LOGGER??
        BOM bom = null;

        String sql = "insert into fog.BOM (quantity, description, idvariants) values (?,?,?)";

        try(Connection connection = connectionPool.getConnection()){
            //trololo
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

            } catch (SQLException ex) {
                throw new DatabaseException("Denne stykliste kunne ikke skabes id atabasen");
            }
        }
        catch (SQLException ex){
            throw new DatabaseException("Denne stykliste kunne ikke skabes id atabasen");
        }

        return bom;
    }

}
