package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    private Integer category_id;
    private String category_name;
    private String category_description;

    private Set<Product> products = new HashSet<>(0);

    public Category(Integer category_id, String category_name, String category_description) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    @Column(name = "category_name")
    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    @Column(name = "category_description")
    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
