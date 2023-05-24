package dat.backend.model.entities.entities;

import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.AdminFacade;
import dat.backend.model.entities.persistence.BomFacade;
import dat.backend.model.entities.persistence.ConnectionPool;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CalculateBOM {

    public ArrayList<BOM> createCarportBOM(Orders order, int length, int width, ConnectionPool connectionPool) throws DatabaseException
    {

        ArrayList<BOM> bom = new ArrayList<>();
        List<Materials> materials = AdminFacade.getAllMaterials(connectionPool);

        //Materials needed for the construction of a carport with a flat roof
        Materials rafters = findMaterialByNameAndLength("spær", raftLengthCalculator(length),materials);
        Materials posts = findMaterialByName("stolpe", materials);
        Materials beamLength = findMaterialByNameAndLength("rem", beamLengthCalculator(length), materials);
        Materials beamWidth = findMaterialByNameAndLength("rem", beamWidthCalculator(length), materials);
        Materials screws = findMaterialByName("skruer", materials);
        Materials trapezoidalRoofPlate = findMaterialByName("trapezplade", materials);

        //Add materials to bom
        bom.add(new BOM(rafters, "carportens tag fastgøres her", raftQuantityCalculator(length)));
        bom.add(new BOM(posts,"stolper til caporten", postQuantityCalculator(length, width)));
        bom.add(new BOM(beamLength, "remme som er konstuktionens langside, her fastgøres spær", 2));
        bom.add(new BOM(beamWidth, "remme som er konstruktionens for og bagkant", 2));
        bom.add(new BOM(screws, "bruges til at samle konstruktionen", 1));
        bom.add(new BOM(trapezoidalRoofPlate, "trapezplader er konstruktionens tag", (raftQuantityCalculator(length)+1)));

        //add bom to database
        for(BOM item : bom){
            BomFacade.createBOM(order, item.getMaterial(), item.descriptionOfUSe, item.getQuantity(), connectionPool);
        }
        return bom;
    }

    public double bomPrice(Orders orders, int choosenID) {
        ConnectionPool connectionPool = new ConnectionPool();
        //Materials materials = new Materials(choosenID);
        ArrayList<BOM> allBOM = new ArrayList<>();
        ArrayList<BOM> specificBOMForPriceCalc = new ArrayList<>();
        double bomPrice = 0;

        //get all BOM from db;
        try {
            allBOM = BomFacade.readBOM(connectionPool);

            //idMaterials skal bruges til at koble på hver bom i allbom
            //hvordan gør jeg det?????

            


            for (BOM bom : allBOM) {
                bomPrice = (bom.getQuantity() * bom.material.getUnitPrice());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return bomPrice;

    }

    //all functions below this point are helper functions for createCarportBOM
    public int beamWidthCalculator(int width) {
        if(width <= 300){
            return 300;
        }
        else if (width <= 360){
            return 360;
        }
        else if (width <= 420){
            return 420;
        }
        else if (width <= 480){
            return 480;
        }
        else if (width <= 540){
            return 540;
        }
        else if(width == 600){return 600;}
        return 600;
    }

    public int beamLengthCalculator(int length) {
        if(length <= 300){
            return 300;
        }
        else if (length <= 360){
            return 360;
        }
        else if (length <= 420){
            return 420;
        }
        else if (length <= 480){
            return 480;
        }
        else if (length <= 540){
            return 540;
        }
        else if(length == 600){return 600;}
        return 600;
    }

    public int raftLengthCalculator(int length) {
        if(length <= 300){
            return 300;
        }
        else if (length <= 360){
            return 360;
        }
        else if (length <= 420){
            return 420;
        }
        else if (length <= 480){
            return 480;
        }
        else if (length <= 540){
            return 540;
        }
        else if(length == 600){return 600;}
        return 600;
    }

    public Materials findMaterialByName(String name, List<Materials> materials) {
        Materials foundMaterial;
        // Iterate through the list of materials
        for (Materials material : materials) {
            if (material.getName().equals(name)) {
                foundMaterial = material;
                return foundMaterial;
            }
        }
        return null;
    }

    public Materials findMaterialByNameAndLength(String name, int length, List<Materials> materials) {
        Materials foundMaterial;
        // Iterate through the list of materials
        for (Materials material : materials) {
            if (material.getName().equals(name) && material.getLength() == length) {
                foundMaterial = material;
                return foundMaterial;
            }
        }
        return null;
    }

    public int postQuantityCalculator(int length, int width) {
        if(length > 450){return 6;}
        else if(width > 450){return 6;}
        else return 4;

    }

    public int raftQuantityCalculator(int length) {
        int numberOfPosts = (length/50)-1;
        return numberOfPosts;
    }

}