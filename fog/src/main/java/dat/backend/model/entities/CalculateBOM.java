package dat.backend.model.entities;

import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;

public class CalculateBOM {
    // TODO: I will recieve two integers and they will be used for calculating bom
    // TODO: make a method that calculate the BOM the price

    //dummy integers for the calculations - these will be replaced and so on
    int l = 400;
    int b = 300;

    public ArrayList<Materials> createBOM(int length, int width){
        // I need to create a new bom from the two integers - the bom has materials and so on.
        //HUSK hjælpemetoder!
        ArrayList<Materials> bom = new ArrayList<>();





        /*
        in the end some data will be added through the BomFacade.createBOM();
        For this i need the ORDER NUMBER (idorders)(idorders gives the ints) and the MATERIAL NUMBER (idmaterials)

        it needs to be a loop that runs through the list of materials and adds the same idbom and idorders to all rows
         */
        return bom;
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
