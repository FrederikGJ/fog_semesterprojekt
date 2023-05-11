package dat.backend.model.entities;

public class Orders {
    private int idorders;
    private int orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private User user;

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
        this.user = user;
    }


    //below is getters
    public int getIdorders() {
        return idorders;
    }

    public int getOrderStatus() {
        return orderStatus;
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

    public User getUser() {
        return user;
    }
}
