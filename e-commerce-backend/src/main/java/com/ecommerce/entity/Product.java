package com.ecommerce.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    private Integer product_id;
    private String  product_name;
    private Integer  price;
    private String  features;
    private Date created_at;
    private String imageUrl;
    private Category category;


    private Set<OrderDetails> order_details= new HashSet<>(0);

    public Product() {
    }

    public Product(String product_name, Integer price, String features,String imageUrl, Date created_at, Category category) {
        this.product_name = product_name;
        this.price = price;
        this.features = features;
        this.imageUrl=imageUrl;
        this.created_at = created_at;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    @Column(name="product_name")
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Column(name="price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    @Column(name="features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
    @Column(name="created_at")
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<OrderDetails> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(Set<OrderDetails> order_details) {
        this.order_details = order_details;
    }
}
