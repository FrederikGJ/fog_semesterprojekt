package dat.backend.model.entities;


public class Orders {
    private int idorders;
    private String orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private User user;
    private String username;

    /*
    public Orders(int orderStatus, int width, int length, int totalPrice, User user) {
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.user = user;
    }
     */

    public Orders(int idorders, String orderStatus, int length, int width, int totalPrice, String username){
        this.idorders = idorders;
        this.orderStatus = orderStatus;
        this.length = length;
        this.width = width;
        this.totalPrice = totalPrice;
        this.username = username;
    }


    public int getIdorders(){
        return idorders;
    }

    public String getOrderStatus(){
        return orderStatus;
    }

    public String getUsername(){
        return username;
    }

}
