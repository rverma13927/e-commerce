package com.ecommerce.service.serviceImpl;

import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserInfoService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseMessageDto saveUser(User user) {

        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
        if (!byUsername.isPresent()) {
            try {
                userRepository.save(user);
                return new ResponseMessageDto("Customer saved successfully", true);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMessageDto("Something went wrong customer is not saved", true);
            }
        } else {
            return new ResponseMessageDto("This Username already exist.Please enter different username", true);
        }
    }
}
