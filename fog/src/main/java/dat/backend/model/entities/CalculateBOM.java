package dat.backend.model.entities;

import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.AdminFacade;
import dat.backend.model.persistence.AdminMapper;
import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;
import java.util.List;

public class CalculateBOM {
    // TODO: I will recieve two integers and they will be used for calculating bom
    // TODO: make a method that calculate the BOM the price

    //dummy integers for the calculations - these will be replaced and so on
    int l = 400;
    int b = 300;
    int idorders = 1; //Orders.getIdOrders;

    public ArrayList<BOM> createBOM(int length, int width, int idorders, ConnectionPool connectionPool) throws DatabaseException {
        // I need to create a new bom from the two integers - the bom has materials and so on.
        //HUSK hjælpemetoder!
        ArrayList<BOM> bom = new ArrayList<>();
        List<Materials> materials = AdminFacade.getAllMaterials(connectionPool);

        //OM SPÆR: her skal jeg bruge en bom fra databasen
        //og så skal den int der retuneres sættes som quantitiy
        //Når jeg har quantity skal jeg også vælge længden
        raftQuantityCalculator(length);
        raftLengthCalculator();
        //OM pæle : denne skal også sættes som quantity
        //+ beslag skal have samme quantity som posts (Carport Saddle Bracket)
        postCalculator(length, width);
        //tilføj rem på length med en if statement

        //tilføj rem width med en if statement

        //tilføj en pakke skruer


        //lav et loop der finder et specifikt material.
        Materials skruer = findMaterial("skruer", materials);

        //raft length finder needs to length as well

        //tilføj alle de materials vi har brug for til listen
        bom.add(new BOM(idorders, skruer, "bruges til at skrue med", 1));


        /*
        in the end some data will be added through the BomFacade.createBOM();
        For this i need the ORDER NUMBER (idorders)(idorders gives the ints) and the MATERIAL NUMBER (idmaterials)

        it needs to be a loop that runs through the list of materials and adds the same idbom and idorders to all rows
         */
        return bom;
    }

    private int raftLengthCalculator(int length) {
        if(length <= 300){
            return 300;
        }
    }

    private Materials findMaterial(String name, List<Materials> materials) {
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

    private int postCalculator(int length, int width) {
        if(length > 450){return 6;}
        else if(width > 450){return 6;}
        else return 4;

    }

    private int raftQuantityCalculator(int length) {
        int numberOfPosts = (length/50)-2;
        return numberOfPosts;
    }

    //calculator that outputs the price of a given offer based on a bom arraylist
    public int bomPrice() {
        ConnectionPool connectionPool = new ConnectionPool();
        ArrayList<BOM> allBOM = new ArrayList<>();
        try {
            allBOM = BomFacade.readBOM(connectionPool);
        } catch (Exception e){
            e.printStackTrace();
        }

        //  find the bom needed form allBOM and add the prices together

        return -1111111;
    }
}
