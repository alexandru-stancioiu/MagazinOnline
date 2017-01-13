package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.CredentialsForm;
import ro.upb.cs.dai.model.ShoppingCart;
import ro.upb.cs.dai.service.LoginService;
import ro.upb.cs.dai.service.ProductService;
import ro.upb.cs.dai.service.ShoppingCartService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stancioi on 12/24/2016.
 */

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    public Map<String, Object> getModel(HttpSession httpSession) {
        List<Product> products = productService.getAllProducts();
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(httpSession);

        Map<String, Object> model = new HashMap<>();
        model.put("role", (String) httpSession.getAttribute("role").toString());
        model.put("products", products);
        model.put("shoppingCart", shoppingCart);

        return model;
    }

    @RequestMapping(value = "/")
    public ModelAndView login(HttpSession httpSession) {
        if (httpSession.getAttribute("logged") != null && httpSession.getAttribute("logged").equals(true)) {

            Map<String, Object> model = getModel(httpSession);
            return new ModelAndView("index", model);
        }
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/do_login")
    public ModelAndView do_login(@ModelAttribute CredentialsForm credentialsForm, HttpSession httpSession) {

        User user = loginService.login(credentialsForm);
        if (user != null) {
            httpSession.setAttribute("logged", true);
            httpSession.setAttribute("role", user.getRole());
            httpSession.setAttribute("user", user);

            Map<String, Object> model = getModel(httpSession);
            return new ModelAndView("index", model);
        }
        return new ModelAndView("login");
    }
}
