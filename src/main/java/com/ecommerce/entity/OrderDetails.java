package com.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    private Integer order_detail_id;
    private Product product;
    private Orders orders;
    private Integer quantity;
    private Integer buying_price;

    public OrderDetails(Product product, Orders orders, Integer quantity, Integer buying_price) {
        this.product = product;
        this.orders = orders;
        this.quantity = quantity;
        this.buying_price = buying_price;
    }

    public OrderDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    public Integer getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Integer order_detail_id) {
        this.order_detail_id = order_detail_id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "buying_price")
    public Integer getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(Integer buying_price) {
        this.buying_price = buying_price;
    }
}
