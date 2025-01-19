package com.product.product_service.controller;

import com.product.product_service.config.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class TestingController {

    @Autowired
    private Message message;

    @GetMapping
    public String getMessage() {
        return message.getMessage();
    }
}
