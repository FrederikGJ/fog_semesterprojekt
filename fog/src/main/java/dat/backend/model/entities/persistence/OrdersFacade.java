package dat.backend.model.entities.persistence;

import dat.backend.model.entities.exceptions.DatabaseException;

public class OrdersFacade {
   public static void  createOrder( int width, int length, String username, String comment, ConnectionPool connectionPool) throws DatabaseException
   {
       OrdersMapper.createOrder(width, length, username, comment, connectionPool);
   }

    /*public static List<Orders> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        return OrdersMapper.getAllOrders(connectionPool);
    }*/
}
