package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.OrderDao;
import ro.upb.cs.dai.dao.ProductDao;
import ro.upb.cs.dai.entities.Order;
import ro.upb.cs.dai.entities.OrderItem;
import ro.upb.cs.dai.entities.Product;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.Pair;
import ro.upb.cs.dai.model.ShoppingCart;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stancioi on 12/28/2016.
 */

@Service
public class ShoppingCartService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

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

    public void updateAvailableQuantities(ShoppingCart shoppingCart) {
        for (Map.Entry<Product, Pair<Integer, Float>> entry : shoppingCart.getProductToRequestedQuantityAndPrice().entrySet()) {
            Product product = entry.getKey();
            product.setQuantity(product.getQuantity() - entry.getValue().getFirst());
            productDao.updateProduct(product);
        }
    }

    private boolean validateShoppingCart(ShoppingCart shoppingCart) {

        for (Map.Entry<Product, Pair<Integer, Float>> entry : shoppingCart.getProductToRequestedQuantityAndPrice().entrySet()) {
            Product product = entry.getKey();
            int availableQuantity = product.getQuantity();
            int desiredQuantity = entry.getValue().getFirst();
            if (desiredQuantity > availableQuantity) {
                return false;
            }
        }

        updateAvailableQuantities(shoppingCart);
        return true;
    }

    public boolean submitShoppingCart(String[] desiredProducts, String[] desiredQuantities, User user, ShoppingCart shoppingCart) {

        int i;

        Map<Product, Pair<Integer, Float>> productToSubmittedQuantityAndPrice = new HashMap<>();
        for (i = 0; i < desiredProducts.length; i++) {
            int productId = Integer.parseInt(desiredProducts[i]);
            int desiredQuantity = Integer.parseInt(desiredQuantities[i]);
            Product product = productDao.findProductById(productId);
            Float price = product.getPrice() * desiredQuantity;
            productToSubmittedQuantityAndPrice.put(product, new Pair<>(desiredQuantity, price));
        }
        shoppingCart.setProductToRequestedQuantityAndPrice(productToSubmittedQuantityAndPrice);
        shoppingCart.updateTotalPrice();

        if (!validateShoppingCart(shoppingCart)) {
            return false;
        }

        Date timestamp = new Date();
        Order order = new Order(user, timestamp, shoppingCart.getTotalPrice());

        List<OrderItem> orderItemList = shoppingCart.getOrderItems(order);
        order.setOrderItems(orderItemList);

        orderDao.save(order);
        return true;
    }
}
