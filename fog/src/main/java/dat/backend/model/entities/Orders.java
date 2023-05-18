package dat.backend.model.entities;

import java.util.List;

public class Orders {

    private int idOrders;
    private String orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private String username;
    private String comments;

    public Orders( int width, int length, String username, String comment) {

        this.width = width;
        this.length = length;
        this.username = username;
        this.comment = comment;
    }

    public Orders(int idOrders, String orderStatus, int length, int width, int totalPrice, String username, String comments){
        this.idOrders = idOrders;
        this.orderStatus = orderStatus;
        this.length = length;
        this.width = width;
        this.totalPrice = totalPrice;
        this.username = username;
        this.comments = comments;
    }


    public int getIdOrders()
    {
        return idOrders;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public String getUsername()
    {
        return username;
    }

    public String getComments()
    {
        return comments;
    }
}
