package com.ecommerce.controller;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.User;
import com.ecommerce.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("{id}")
    ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(userInfoService.findUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<ResponseMessageDto> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userInfoService.saveUser(user), HttpStatus.OK);
    }

}
