package dat.backend.model.entities;

import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;

public class CalculateBOM {
    //I will recieve two integers and they will be used for calculating the bill of materials

    //dummy integers for the calculations - these will be replaced and so on
    int l = 400;
    int b = 300;

    //calculator that outputs the price of a given offer based on a bom arraylist
    //I need a bomMapper instance tor ead the BOM from the database with the read bom funciton


    public int bomPrice() {
        ConnectionPool connectionPool = new ConnectionPool();
        ArrayList<BOM> bomPriceCalculation = new ArrayList<>();
        try {
            bomPriceCalculation = BomFacade.readBOM(connectionPool);
        } catch (Exception e){
            e.printStackTrace();
        }

        //bomPriceCalculation

        return -1111111;
    }
}
