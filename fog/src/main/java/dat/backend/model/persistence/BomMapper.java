package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;
import dat.backend.model.entities.Materials;
import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomMapper {

























    static ArrayList<BOM> getBOMById(int idOrders, ConnectionPool connectionPool) throws DatabaseException {
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");
        BOM bom;

        String sql = "SELECT * FROM fog.BOM WHERE idorders = ?";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, idOrders);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    String descriptionOfUse = rs.getString("description");
                    int idMaterials = rs.getInt("idmaterials");
                    bom = new BOM(idOrders, quantity, descriptionOfUse, idMaterials);
                    bomArrayList.add(bom);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database when you tried to get BOM via ordersID");
        }
        return bomArrayList;
    }



}
