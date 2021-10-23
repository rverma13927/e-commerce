package com.ecommerce.service;

import com.ecommerce.dto.RequestDto.OrderRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Orders;

public interface OrdersService {

    Orders getOrderDetailById(Integer order_id);

    ResponseMessageDto saveOrderDetail(OrderRequestDto orders);
}
