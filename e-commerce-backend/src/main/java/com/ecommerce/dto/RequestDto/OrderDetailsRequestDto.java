package com.ecommerce.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDetailsRequestDto {
    private Integer product_id;
    private Integer quantity;
    private Integer buying_price;
}
