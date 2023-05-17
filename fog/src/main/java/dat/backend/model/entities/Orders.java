package dat.backend.model.entities;

import java.util.List;

public class Orders {

    private int idOrders;
    private String orderStatus;
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


    public Orders(int idOrders, String orderStatus, int length, int width, int totalPrice, String username){
        this.idOrders = idOrders;
        this.orderStatus = orderStatus;
        this.length = length;
        this.width = width;
        this.totalPrice = totalPrice;
        this.username = username;
    }


    public Orders(int idOrders, String orderStatus, int width, int length, int totalPrice, String username, String comment) {
        this.idOrders = idOrders;
    public Orders(int idorders,int orderStatus, int width, int length, int totalPrice, User user) {
        this.idorders = idorders;
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Orders(int orderStatus, int width, int length, int totalPrice, User user) {

        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.username = username;
        this.comment = comment;
    }

}
