package dat.backend.model.entities;

import java.util.List;

public class Orders {

    private int idOrders;
    private int orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private String username;

    public Orders(int idOrders, int orderStatus, int width, int length, int totalPrice, String username) {
        this.idOrders = idOrders;
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.username = username;
    }
}
