package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.entities.Role;
import ro.upb.cs.dai.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by stancioi on 12/25/2016.
 */

@Controller
public class CatalogController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/catalog")
    public ModelAndView catalog(HttpSession httpSession) {

        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true) &&
                httpSession.getAttribute("role").equals(Role.ADMIN)) {

            List<Product> products = productService.getAllProducts();

            return new ModelAndView("catalog", "products", products);
        }

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/update_delete_product")
    public ModelAndView updateOrDeleteProduct(HttpSession httpSession, @ModelAttribute Product product,
                                              @RequestParam String action) {

        if (httpSession.getAttribute("logged") != null &&
                httpSession.getAttribute("logged").equals(true) &&
                httpSession.getAttribute("role").equals(Role.ADMIN)) {

            productService.updateOrDeleteProduct(action, product);

            List<Product> products = productService.getAllProducts();
            return new ModelAndView("catalog", "products", products);
        }

        return new ModelAndView("login");
    }
}
