package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {

    Materials material;
    String descriptionOfUSe;
    int quantity;

    public BOM(Materials material, String descriptionOfUSe, int quantity) {
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }
}
