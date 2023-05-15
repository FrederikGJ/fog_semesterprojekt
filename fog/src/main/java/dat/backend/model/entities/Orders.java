package dat.backend.model.entities;

import java.util.List;

public class Orders {

    private int idOrders;
    private int orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private String username;
    private String comment;

    public Orders( int width, int length, String username, String comment) {

        this.width = width;
        this.length = length;
        this.username = username;
        this.comment = comment;
    }
}
