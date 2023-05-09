package dat.backend.model.entities;

public class Orders {
    private int orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private User user;

    public Orders(int orderStatus, int width, int length, int totalPrice, User user) {
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.user = user;
    }
}
