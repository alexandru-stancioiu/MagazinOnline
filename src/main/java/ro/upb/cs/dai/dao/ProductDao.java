package ro.upb.cs.dai.dao;

import ro.upb.cs.dai.entities.Product;

import java.util.List;

/**
 * Created by stancioi on 12/26/2016.
 */
public interface ProductDao {

    void save(Product product);

    List<Product> getAllProduct();

    Product findProductById(Integer id);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
