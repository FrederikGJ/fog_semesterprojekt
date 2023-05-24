package dat.backend.model.entities.entities;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    Orders orders = new Orders();

    @Test
    void makeGrossProfit() {

        double salespriceTaxFree = 100;
        double totalBomPrice = 50;
        double exprected = 50;
        double unexpected = 49;
        assertEquals(exprected, orders.makeGrossProfit(salespriceTaxFree,totalBomPrice));
        assertNotEquals(unexpected, orders.makeGrossProfit(salespriceTaxFree,totalBomPrice));
    }

    //the delta values are the margin of error between the expected value and the actual value
    @Test
    public void testMakeOperationMargin_positiveValues() {
        double grossProfit = 50.0;
        double salespriceTaxFree = 100.0;
        double expected = 50.0;
        assertEquals(expected, orders.makeOperationMargin(grossProfit, salespriceTaxFree), 0.01);
    }

    @Test
    public void testMakeOperationMargin_zeroGrossProfit() {
        double grossProfit = 0.0;
        double salespriceTaxFree = 100.0;
        double expected = 0.0;
        assertEquals(expected, orders.makeOperationMargin(grossProfit, salespriceTaxFree), 0.01);
    }

    @Test
    public void testMakeOperationMargin_negativeValues() {
        double grossProfit = -50.0;
        double salespriceTaxFree = -100.0;
        double expected = 50.0;
        assertEquals(expected, orders.makeOperationMargin(grossProfit, salespriceTaxFree), 0.01);
    }


}