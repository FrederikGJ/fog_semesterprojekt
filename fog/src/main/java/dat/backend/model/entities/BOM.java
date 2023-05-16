package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {

    int idBOM;
    Materials material;
    String descriptionOfUSe;
    int quantity;

    //for the read CRUD operation in mapper we have
    int idmaterial;

    public BOM(int idBOM,Materials material, String descriptionOfUSe, int quantity) {
        this.idBOM = idBOM;
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(int idBOM, int idmaterial, String descriptionOfUSe, int quantity){
        this.idBOM = idBOM;
        this.idmaterial = idmaterial;
        this. descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }
}
