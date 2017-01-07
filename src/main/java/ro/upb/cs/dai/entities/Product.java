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
    private String quantity;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
