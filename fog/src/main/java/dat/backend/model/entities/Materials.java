package dat.backend.model.entities;

public class Materials {

    private int idMaterials;
    private String name;
    private int unitPrice;
    private String unit;
    private String description;
    private int length;

    public Materials(String name, int unitPrice, String unit, String description) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
    }

    public int getIdMaterials()
    {
        return idMaterials;
    }
}
