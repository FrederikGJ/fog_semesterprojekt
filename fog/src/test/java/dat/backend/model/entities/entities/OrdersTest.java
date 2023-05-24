package dat.backend.model.entities.entities;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    void makeGrossProfit() {
        Orders orders = new Orders();
        assertEquals(50, orders.makeGrossProfit(100,50));
        assertNotEquals(49, orders.makeGrossProfit(100,50));
    }

    @Test
    void makeOperationMargin() {
        Orders orders = new Orders();

    }
}