package dat.backend.model.entities.entities;

import java.util.List;

public class BOM {

    int idOrders;
    Materials material;
    String descriptionOfUSe;
    int quantity;

    //for the read CRUD operation in mapper we have
    int idMaterials;


   /* public BOM(int quantity, String descriptionOfUSe,int idMaterials)
    {
        this.quantity = quantity;
        this.descriptionOfUSe = descriptionOfUSe;
        this.idMaterials = idMaterials;
    }*/


    public BOM(Materials material, String descriptionOfUSe, int quantity) {
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }


    public BOM(int idOrders, int quantity, String descriptionOfUse, int idMaterials)
    {
        this.idOrders = idOrders;
        this.quantity = quantity;
        this.descriptionOfUSe = descriptionOfUse;
        this.idMaterials = idMaterials;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public Materials getMaterial(){
        return material;
    }

    public String getDescriptionOfUSe() {
        return descriptionOfUSe;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdMaterials() {
        return idMaterials;
    }


}
