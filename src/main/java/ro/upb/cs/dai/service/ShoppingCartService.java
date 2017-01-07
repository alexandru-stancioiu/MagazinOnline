package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.ProductDao;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.model.Pair;
import ro.upb.cs.dai.model.ShoppingCart;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by stancioi on 12/28/2016.
 */

@Service
public class ShoppingCartService {

    @Autowired
    private ProductDao productDao;

    public ShoppingCart getShoppingCart(HttpSession httpSession) {
        if (httpSession.getAttribute("shoppingCart") == null) {
            ShoppingCart shoppingCart = new ShoppingCart();
            httpSession.setAttribute("shoppingCart", shoppingCart);

            return shoppingCart;
        }

        return (ShoppingCart) httpSession.getAttribute("shoppingCart");
    }

    public void addProductToShoppingCart(HttpSession httpSession, Integer productId, Integer desiredQuantity) {

        ShoppingCart shoppingCart = getShoppingCart(httpSession);

        Product product = productDao.findProductById(productId);
        Float price = product.getPrice() * desiredQuantity;

        Map<Product, Pair<Integer, Float>> productToRequestedQuantityAndPrice = shoppingCart.getProductToRequestedQuantityAndPrice();
        if (productToRequestedQuantityAndPrice.containsKey(product)) {
            Pair<Integer, Float> existingQuantityAndPrice = productToRequestedQuantityAndPrice.get(product);
            productToRequestedQuantityAndPrice.remove(product);
            desiredQuantity = desiredQuantity + existingQuantityAndPrice.getFirst();
            price = desiredQuantity * product.getPrice();
        }

        shoppingCart.getProductToRequestedQuantityAndPrice().put(product, new Pair<>(desiredQuantity, price));
        shoppingCart.updateTotalPrice();
    }
}
