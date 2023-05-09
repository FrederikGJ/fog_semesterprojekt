package dat.backend.model.entities;

import java.util.ArrayList;

public class BOM {

    private int quantity;
    private String description;
    private int variant;

    public BOM(int quantity, String description, int variant) {
        this.quantity = quantity;
        this.description = description;
        this.variant = variant;
    }
}
