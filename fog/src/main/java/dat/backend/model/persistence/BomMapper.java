package dat.backend.model.persistence;

import dat.backend.model.entities.BOM;

import java.util.ArrayList;

public class BomMapper {

    static BOM createBOM(){
        BOM bom = null; //HUSK AT FJERNE NULL
        String sql = "insert into fog.BOM (username, password, role) values (?,?,?)";
     return bom;
    }

    static ArrayList<BOM> readBOM(){
        ArrayList<BOM> bomArrayList = new ArrayList<>();
        BOM bom = null;
        bomArrayList.add(bom);
        return bomArrayList;
    }


}
