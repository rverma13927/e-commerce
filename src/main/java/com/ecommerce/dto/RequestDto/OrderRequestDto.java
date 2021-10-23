package com.ecommerce.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequestDto implements Serializable {

    private Integer order_id;
    private Integer customer_id;
    private Integer amount;
    private String shipping_Address;
    private String order_email;
    private String order_phone;
    private Boolean order_status;
    private List<OrderDetailsRequestDto> orderDetailsRequestDtos;
}
