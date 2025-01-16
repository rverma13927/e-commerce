package com.ecommerce.controller;

import com.ecommerce.dto.RequestDto.CartRequestDto;
import com.ecommerce.service.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@CrossOrigin("*")
public class CartController {
        @Autowired
   private CartServices cartServices;

  @PostMapping("add")
  public ResponseEntity<?> saveIntoCart(@RequestBody CartRequestDto cartRequestDto){
            return new ResponseEntity<>(cartServices.saveIntoCart(cartRequestDto), HttpStatus.OK);
  }
}
