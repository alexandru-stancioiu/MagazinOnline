package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.ProductDao;
import ro.upb.cs.dai.entities.Product;

import java.util.List;

/**
 * Created by stancioi on 12/26/2016.
 */

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void addProductToCatalog(Product product) {
        productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProduct();
    }

    public void updateOrDeleteProduct(String action, Product product) {
        switch (action) {
            case "Update":
                updateProduct(product);
                break;
            case "Delete":
                deleteProduct(product);
                break;
        }
    }

    private void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    private void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
