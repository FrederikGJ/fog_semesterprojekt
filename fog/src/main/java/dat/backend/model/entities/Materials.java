package dat.backend.model.entities;

public class Materials {
    private int idMaterials;
    private String name;
    private int unitPrice;
    private String unit;
    private String description;

    public Materials(int idMaterials, String name, int unitPrice, String unit, String description) {
        this.idMaterials= idMaterials;
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
    }

    public int getIdMaterials() {
        return idMaterials;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }
}
