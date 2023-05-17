package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOM {

    private int idOrders;
    private int quantity;
    private String descriptionOfUse;

    //for the read CRUD operation in mapper we have
    private int idMaterials;


    public BOM(int idOrders, int quantity, String descriptionOfUse, int idMaterials)
    {
        this.idOrders = idOrders;
        this.quantity = quantity;
        this.descriptionOfUse = descriptionOfUse;
        this.idMaterials = idMaterials;
    }

    public int getIdOrders()
    {
        return idOrders;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getDescriptionOfUse()
    {
        return descriptionOfUse;
    }

    public int getIdMaterials()
    {
        return idMaterials;
    }


}
