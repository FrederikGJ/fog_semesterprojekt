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
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.username = username;
        this.comment = comment;
    }

    public int getIdorders(){
        return idOrders;
    }

    public String getOrderStatus(){
        return orderStatus;
    }

    public String getUsername(){
        return username;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getComment() {
        return comment;
    }
   /* public int assignInteger(String inputString) {
        int assignedInteger = 0;

        if (inputString.equals("New")) {
            assignedInteger = 1;
        } else if (inputString.equals("Pending")) {
            assignedInteger = 2;
        } else if (inputString.equals("Finished")) {
            assignedInteger = 3;
        }
        return assignedInteger;
    }*/
}
