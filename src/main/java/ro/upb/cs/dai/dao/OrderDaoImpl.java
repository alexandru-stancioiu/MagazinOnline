package ro.upb.cs.dai.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.cs.dai.entities.Order;
import ro.upb.cs.dai.entities.User;

import java.util.List;

/**
 * Created by stancioi on 1/8/2017.
 */

@Repository
@Transactional
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

    @Override
    public void save(Order order) {
        persist(order);
    }

    @Override
    public List<Order> findAllOrdersOfUser(User user) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("user", user));
        List<Order> orders = crit.list();
        return orders;
    }
}
