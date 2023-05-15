package dat.backend.model.entities;

public class Materials {
    private int idMaterials;
    private String name;
    private int unitPrice;
    private String unit;
    private String description;
    private int length;

    public Materials(int idMaterials, String name, int unitPrice, String unit, String description, int length) {
        this.idMaterials= idMaterials;
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
        this.length = length;
    }

    public Materials (String name, int unitPrice, String unit, String description, int length) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.description = description;
        this.length = length;
    }

    public int getIdMaterials() {return idMaterials;}

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

    public int getLength() {return length;}

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Materials{" +
                "idMaterials=" + idMaterials +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
