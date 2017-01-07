package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Role;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by stancioi on 12/26/2016.
 */

@Controller
public class AddProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/add_product")
    public String addProduct(HttpSession httpSession, @ModelAttribute Product productForm) {
        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true) &&
                httpSession.getAttribute("role").equals(Role.ADMIN)) {
            return "add_product";
        } else {
            return "login";
        }
    }

    @RequestMapping("/do_add_product")
    public ModelAndView doAddProduct(HttpSession httpSession, @ModelAttribute Product product) {
        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true) &&
                httpSession.getAttribute("role").equals(Role.ADMIN)) {

            productService.addProductToCatalog(product);
            List<Product> products = productService.getAllProducts();

            return new ModelAndView("catalog", "products", products);
        }

        return new ModelAndView("login");
    }
}
