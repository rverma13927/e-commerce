package com.ecommerce;

import com.ecommerce.config.SimpleCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }


    @Bean
    SimpleCorsFilter corsFilter() {
        return new SimpleCorsFilter();
    }
}
