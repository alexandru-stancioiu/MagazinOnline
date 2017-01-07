package ro.upb.cs.dai.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.cs.dai.entities.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stancioi on 12/26/2016.
 */

@Repository
@Transactional
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    public void save(Product product) {
        persist(product);
    }

    public List<Product> getAllProduct() {
        Criteria crit = createEntityCriteria();
        List<Product> products = crit.list();
        return products;
    }

    @Override
    public Product findProductById(Integer id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Product product = (Product) crit.uniqueResult();
        return product;
    }

    public void updateProduct(Product product) {
        update(product);
    }

    public void deleteProduct(Product product) {
        delete(product);
    }
}
