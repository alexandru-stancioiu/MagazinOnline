package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.entities.Role;
import ro.upb.cs.dai.model.ShoppingCart;
import ro.upb.cs.dai.service.ProductService;
import ro.upb.cs.dai.service.ShoppingCartService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by stancioi on 12/28/2016.
 */

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

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
}
