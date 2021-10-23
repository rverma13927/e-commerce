package com.ecommerce.controller;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<ResponseMessageDto> addCustomer(@RequestBody Customer customer) {
        customer.setCreated_at(new Date());
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

}
