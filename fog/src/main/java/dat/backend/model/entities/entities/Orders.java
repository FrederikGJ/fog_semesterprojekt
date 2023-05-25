package dat.backend.model.entities.entities;

public class Orders {

    private int idOrders;
    private String orderStatus;
    private int width;
    private int length;
    private int totalPrice;
    private String username;
    private String comments;


    public Orders(int idOrders, String orderStatus, int length, int width, int totalPrice, String username, String comments){
        this.idOrders = idOrders;
        this.orderStatus = orderStatus;
        this.length = length;
        this.width = width;
        this.totalPrice = totalPrice;
        this.username = username;
        this.comments = comments;
    }

    public Orders(int idOrders, String orderStatus, int width, int length, int totalPrice, String username)
    {
        this.idOrders = idOrders;
        this.orderStatus = orderStatus;
        this.width = width;
        this.length = length;
        this.totalPrice = totalPrice;
        this.username = username;
    }

    public Orders(int width, int length, String username, String comments)
    {
        this.width = width;
        this.length = length;
        this.username = username;
        this.comments = comments;
    }

    public Orders() { }

    public Orders(int idOrders) {
        this.idOrders = idOrders;
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



    //dækningsbidrag
    public double makeGrossProfit(double salespriceTaxFree, double totalBomPrice)
    {
    double grossProfit = salespriceTaxFree - totalBomPrice;
    return grossProfit;
    }

    //dækningsgraden
    public double makeOperationMargin(double grossProfit, double salespriceTaxFree) {
        if (salespriceTaxFree == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        double operationMargin = grossProfit * 100 / salespriceTaxFree;
        return operationMargin;
    }


}
