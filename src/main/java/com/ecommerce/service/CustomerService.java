package com.ecommerce.service;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Customer;

public interface CustomerService {

     Customer findCustomerById(Integer id);

     ResponseMessageDto saveCustomer(Customer customer);
}
