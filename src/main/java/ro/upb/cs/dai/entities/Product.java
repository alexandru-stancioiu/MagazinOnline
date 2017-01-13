package ro.upb.cs.dai.entities;

import javax.persistence.*;

/**
 * Created by stancioi on 12/26/2016.
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!productName.equals(product.productName)) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (!price.equals(product.price)) return false;
        return quantity.equals(product.quantity);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + productName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }
}
