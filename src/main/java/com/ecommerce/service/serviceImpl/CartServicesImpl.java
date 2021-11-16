package com.ecommerce.service.serviceImpl;

import com.ecommerce.dto.RequestDto.CartRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServicesImpl implements CartServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseMessageDto saveIntoCart(CartRequestDto cartRequestDto) {

        Optional<User> user =userRepository.findById(Long.valueOf(cartRequestDto.getUserId()));
        if (user.isPresent()) {

            String[] split = user.get().getCartItems()!=null ? user.get().getCartItems().split(",") : new String[]{};
            if(split.length!=0){
                String concat = user.get().getCartItems().concat("," + cartRequestDto.getProductId());
                user.get().setCartItems(concat);
            }else {
                user.get().setCartItems(cartRequestDto.getProductId());
                userRepository.save(user.get());
            }
           return  new ResponseMessageDto("Cart Items saved successfully !",true);
        }

        return null;
    }
}
