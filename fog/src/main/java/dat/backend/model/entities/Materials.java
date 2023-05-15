package dat.backend.model.entities;

public class Materials {
    private int idmaterials;
    private String name;
    private int unitPrice;
    private String unit;
    private String description;
    private int length;

    public Materials(String name, int unitPrice, String unit, String description, int length) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
        this.length = length;
    }

    public Materials(int idmaterials, String name, int unitPrice, String unit, String description, int length) {
        this.idmaterials = idmaterials;
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
        this.length = length;
    }

    //getters below

    public int getIdmaterials() {
        return idmaterials;
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

    public int getLength() {
        return length;
    }
}
