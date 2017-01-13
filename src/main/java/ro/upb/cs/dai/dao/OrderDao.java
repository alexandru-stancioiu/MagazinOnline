package ro.upb.cs.dai.dao;

import ro.upb.cs.dai.entities.Order;
import ro.upb.cs.dai.entities.User;

import java.util.List;

/**
 * Created by stancioi on 1/8/2017.
 */
public interface OrderDao {

    void save(Order order);

    List<Order> findAllOrdersOfUser(User user);
}
