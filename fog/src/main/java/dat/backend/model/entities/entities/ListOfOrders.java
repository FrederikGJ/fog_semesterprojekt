package dat.backend.model.entities.entities;

import java.util.ArrayList;
import java.util.List;

public class ListOfOrders {
    public List<Orders> orderList = new ArrayList<>();

    public ListOfOrders(){
    //tom constructor
    }
    public void add(Orders order) {
        orderList.add(order);
    }

}
