package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.OrderDao;
import ro.upb.cs.dai.entities.Order;
import ro.upb.cs.dai.entities.User;

import java.util.List;

/**
 * Created by stancioi on 1/10/2017.
 */

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> findAllOrdersOfUser(User user) {
        return orderDao.findAllOrdersOfUser(user);
    }
}
