package dat.backend.model.entities;


public class Orders {
    private int idorders;
    private String orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private String username;
    private String comments;


    public Orders(int idorders, String orderStatus, int length, int width, int totalPrice, String username, String comments){
        this.idorders = idorders;
        this.orderStatus = orderStatus;
        this.length = length;
        this.width = width;
        this.totalPrice = totalPrice;
        this.username = username;
        this.comments = comments;
    }


    public int getIdorders()
    {
        return idorders;
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
