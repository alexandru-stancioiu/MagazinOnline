package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Order;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by stancioi on 1/10/2017.
 */

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/view_orders")
    public ModelAndView viewTransactions(HttpSession httpSession) {
        if (httpSession.getAttribute("logged") != null && httpSession.getAttribute("logged").equals(true)) {

            User user = (User) httpSession.getAttribute("user");
            List<Order> orders = orderService.findAllOrdersOfUser(user);
            return new ModelAndView("orders", "orders", orders);
        }
        return new ModelAndView("login");
    }
}
