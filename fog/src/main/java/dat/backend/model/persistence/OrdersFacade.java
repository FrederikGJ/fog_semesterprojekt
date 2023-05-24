package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class OrdersFacade {
   public static void  createOrder( int width, int length, String username, String comment, ConnectionPool connectionPool) throws DatabaseException {
       OrdersMapper.createOrder(width, length, username, comment, connectionPool);
   }
   public static void statusFinished(int idOrders, ConnectionPool connectionPool) throws DatabaseException {
       OrdersMapper.statusFinished(idOrders, connectionPool);
   }

}
