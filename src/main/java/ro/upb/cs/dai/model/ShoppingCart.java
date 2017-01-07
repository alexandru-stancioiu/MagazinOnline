package ro.upb.cs.dai.model;

import ro.upb.cs.dai.entities.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stancioi on 12/28/2016.
 */
public class ShoppingCart {

    private Map<Product, Pair<Integer, Float>> productToRequestedQuantityAndPrice;
    private Float totalPrice;

    public ShoppingCart() {
        productToRequestedQuantityAndPrice = new HashMap<>();
        totalPrice = 0.0f;
    }

    public Map<Product, Pair<Integer, Float>> getProductToRequestedQuantityAndPrice() {
        return productToRequestedQuantityAndPrice;
    }

    public void setProductToRequestedQuantityAndPrice(Map<Product, Pair<Integer, Float>> productIdToRequestedQuantityAndPrice) {
        this.productToRequestedQuantityAndPrice = productIdToRequestedQuantityAndPrice;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = 0.0f;
        for (Map.Entry<Product, Pair<Integer, Float>> entry : productToRequestedQuantityAndPrice.entrySet()) {
            totalPrice += entry.getValue().getFirst() * entry.getValue().getSecond();
        }
    }
}
