package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class OrdersFacade {
   public static Orders createOrder(int orderstatus, int width, int length, int totalprice, User user, ConnectionPool connectionPool) throws DatabaseException {
       return OrdersMapper.createOrder(orderstatus, width, length, totalprice, user, connectionPool);
   }
}
