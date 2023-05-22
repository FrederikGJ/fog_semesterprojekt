package dat.backend.model.entities.entities;

public class BOM {

    int idOrders;
    Materials material;
    String descriptionOfUSe;
    int quantity;

    //for the read CRUD operation in mapper we have
    int idMaterials;


    public BOM(int idMaterials, String descriptionOfUSe, int quantity)
    {
        this.idMaterials = idMaterials;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(int idOrders, String descriptionOfUSe, int quantity, int idMaterials)
    {
        this.idOrders = idOrders;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
        this.idMaterials = idMaterials;
    }

    public BOM(Materials material, String descriptionOfUSe, int quantity) {
        this.material = material;
        this.descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public BOM(int idOrders, int idMaterials, String descriptionOfUSe, int quantity){
        this.idMaterials = idMaterials;
        this. descriptionOfUSe = descriptionOfUSe;
        this.quantity = quantity;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public Materials getMaterial() {
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
