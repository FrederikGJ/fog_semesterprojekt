package dat.backend.model.entities;

import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;

public class CalculateBOM {
    // TODO: I will recieve two integers and they will be used for calculating the bill of materials and the price

    //dummy integers for the calculations - these will be replaced and so on
    int l = 400;
    int b = 300;

    // I need to create a new bom from the two integers - the bom has materials and so on.

    public void createBOM(){
        //here we need the calculations
        //HUSK hjælpemetoder!! det er guld værd!!!
    }

    //calculator that outputs the price of a given offer based on a bom arraylist
    //I need a bomMapper instance tor ead the BOM from the database with the read bom funciton
    public int bomPrice() {
        ConnectionPool connectionPool = new ConnectionPool();
        ArrayList<BOM> allBOM = new ArrayList<>();
        try {
            allBOM = BomFacade.readBOM(connectionPool);
        } catch (Exception e){
            e.printStackTrace();
        }

        // take find the bom needed form allBOM and add the prices together

        return -1111111;
    }
}
