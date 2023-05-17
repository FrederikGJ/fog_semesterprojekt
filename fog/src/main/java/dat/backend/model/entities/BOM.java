package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {

    int idorders;
    Materials material;
    String descriptionOfUSe;
    int quantity;

    //for the read CRUD operation in mapper we have
    int idmaterial;

    public BOM(int idorders, Materials material, String descriptionOfUSe, int quantity) {
        this.idorders = idorders;
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(Materials material, String descriptionOfUSe, int quantity) {
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(int idmaterial, String descriptionOfUSe, int quantity){
        this.idmaterial = idmaterial;
        this. descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }
}
