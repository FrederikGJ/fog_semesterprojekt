package dat.backend.model.entities.persistence;

import dat.backend.model.entities.exceptions.DatabaseException;

public class OrdersFacade {

   public static void  createOrder( int width, int length, String username, String comment, ConnectionPool connectionPool) throws DatabaseException{
       OrdersMapper.createOrder(width, length, username, comment, connectionPool);
   }

    public static void updateOrder(String orderStatus, double totalPrice, String comments, int idOrders, ConnectionPool connectionPool) throws DatabaseException{
       OrdersMapper.updateOrder(orderStatus, totalPrice, comments, idOrders, connectionPool);
    }


    /*public static List<Orders> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        return OrdersMapper.getAllOrders(connectionPool);
    }*/
}
