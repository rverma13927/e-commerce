package com.ecommerce.service.serviceImpl;

import com.ecommerce.Repository.CustomerRepository;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseMessageDto saveCustomer(Customer customer) {

        Optional<Customer> byUsername = customerRepository.findByUsername(customer.getUsername());
        if(!byUsername.isPresent()){
            try{
                customerRepository.save(customer);
                return new ResponseMessageDto("Customer saved successfully",true);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseMessageDto("Something went wrong customer is not saved",true);
            }
        }else{
            return new ResponseMessageDto("This Username already exist.Please enter different username",true);
        }
    }
}
