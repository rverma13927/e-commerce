package com.ecommerce.controller;

import com.ecommerce.dto.RequestDto.OrderRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("{order_id}")
    ResponseEntity<Orders> getOrderDetailById(@PathVariable(value = "order_id") Integer order_id) {
        return new ResponseEntity<>(ordersService.getOrderDetailById(order_id), HttpStatus.OK);
    }

    @PostMapping("save")
    ResponseEntity<ResponseMessageDto> saveOrderDetail(@RequestBody OrderRequestDto orders) {
        return new ResponseEntity<>(ordersService.saveOrderDetail(orders), HttpStatus.OK);
    }

}
