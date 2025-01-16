package com.ecommerce.service;

import com.ecommerce.dto.RequestDto.CartRequestDto;
import com.ecommerce.dto.ResponseMessageDto;

public interface CartServices {

    ResponseMessageDto saveIntoCart(CartRequestDto cartRequestDto);
}
