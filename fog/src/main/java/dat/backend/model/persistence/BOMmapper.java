package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BOMmapper {

    static BOM createBOM(){
        Logger.getLogger("web").log(Level.INFO, "");
        BOM bom = null;
        String sql = "insert into fog.BOM (quantity, description, idvariants) values (?,?,?)";



        return bom;
    }

}
