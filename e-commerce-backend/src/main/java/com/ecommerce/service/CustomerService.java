package com.ecommerce.service;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Customer;

public interface CustomerService {
     ResponseMessageDto saveCustomer(Customer customer);
     public Customer findCustomerById(Integer id);
}
