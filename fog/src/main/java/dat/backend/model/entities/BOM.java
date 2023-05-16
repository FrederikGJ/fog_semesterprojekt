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
    int idmaterials;

    public BOM(int idBOM,Materials material, String descriptionOfUSe, int quantity) {
        this.idBOM = idBOM;
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(int idBOM, int idmaterial, String descriptionOfUSe, int quantity){
        this.idBOM = idBOM;
        this.idmaterials = idmaterials;
        this. descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public int getIdBOM()
    {
        return idBOM;
    }

    public Materials getMaterial()
    {
        return material;
    }

    public String getDescriptionOfUSe()
    {
        return descriptionOfUSe;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getIdmaterials()
    {
        return idmaterials;
    }
}
