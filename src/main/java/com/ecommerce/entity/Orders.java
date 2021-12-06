package com.ecommerce.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {

    private Integer order_id;
    private User user_id;
    private Integer amount;
    private String shipping_Address;
    private String order_email;
    private String order_phone;
    private Boolean order_status;

    private Set<OrderDetails> order_details = new HashSet<>(0);

    public Orders() {
    }

    public Orders(User user_id, Integer amount, String shipping_Address, String order_email, String order_phone, Boolean order_status) {
        this.user_id = user_id;
        this.amount = amount;
        this.shipping_Address = shipping_Address;
        this.order_email = order_email;
        this.order_phone = order_phone;
        this.order_status = order_status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "shipping_Address")
    public String getShipping_Address() {
        return shipping_Address;
    }

    public void setShipping_Address(String shipping_Address) {
        this.shipping_Address = shipping_Address;
    }
    @Column(name= "order_email")
    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }
    @Column(name= "order_phone")
    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone;
    }
    @Column(name= "order_status")
    public Boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Boolean order_status) {
        this.order_status = order_status;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orders")
    public Set<OrderDetails> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(Set<OrderDetails> order_details) {
        this.order_details = order_details;
    }
}
