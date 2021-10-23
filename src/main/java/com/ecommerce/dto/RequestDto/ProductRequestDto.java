package com.ecommerce.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {
    private String product_name;
    private Integer price;
    private String features;
    private Integer category;
}
