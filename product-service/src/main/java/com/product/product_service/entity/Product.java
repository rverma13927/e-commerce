package com.product.product_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;

    // Field to store image as binary data
    private Binary image;

}
