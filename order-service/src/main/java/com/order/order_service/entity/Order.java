package com.order.order_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private String status; // Example: PENDING, COMPLETED, CANCELED

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date orderDate = new Date();
}
