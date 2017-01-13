package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.ShoppingCart;
import ro.upb.cs.dai.service.ProductService;
import ro.upb.cs.dai.service.ShoppingCartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by stancioi on 12/28/2016.
 */

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private LoginController loginController;

    @RequestMapping("/add_to_shopping_cart")
    public ModelAndView addProductToShoppingCart(@RequestParam Integer id, @RequestParam Integer desiredQuantity,
                                                 HttpSession httpSession) {

        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true)) {

            shoppingCartService.addProductToShoppingCart(httpSession, id, desiredQuantity);

            List<Product> products = productService.getAllProducts();
            return new ModelAndView("index", "products", products);
        }

        return new ModelAndView("login");
    }

    @RequestMapping("/submit_shopping_cart")
    public ModelAndView submitShoppingCart(HttpServletRequest request, HttpSession httpSession) {
        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true)) {

            String[] desiredProducts = request.getParameterValues("id");
            String[] desiredQuantities = request.getParameterValues("quantity");
            User user = (User) httpSession.getAttribute("user");
            ShoppingCart shoppingCart = (ShoppingCart)  httpSession.getAttribute("shoppingCart");
            boolean valid = shoppingCartService.submitShoppingCart(desiredProducts, desiredQuantities, user, shoppingCart);

            if (valid) {
                httpSession.setAttribute("shoppingCart", null);
            }

            Map<String, Object> model = loginController.getModel(httpSession);
            return new ModelAndView("index", model);
        }
        return new ModelAndView("login");
    }
}
