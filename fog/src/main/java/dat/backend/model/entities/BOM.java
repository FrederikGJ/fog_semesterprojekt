package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {


    /*
    hashMap med en instans af Materials klassen og en integer
     */

    Variants variant;
    int quantity;
    HashMap<Variants, Integer> billOfMaterials;

    public BOM(Variants variant, int quantity) {
        this.variant = variant;
        this.quantity = quantity;
    }

    public void addToBOM(Variants variant, int i){
        billOfMaterials.put(variant, i);
    }


}
