package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {

    int idBOM;
    Materials material;
    String descriptionOfUSe;
    int quantity;

    public BOM(int idBOM,Materials material, String descriptionOfUSe, int quantity) {
        this.idBOM = idBOM;
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }
}
