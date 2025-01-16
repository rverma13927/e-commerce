package com.ecommerce.service;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInfoService extends UserDetailsService {

     User findUserById(Long id);

     ResponseMessageDto saveUser(User user);
}
