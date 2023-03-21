package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.UserDTO;
import com.iam.forum.api.controller.mapper.UserMapper;
import com.iam.forum.model.dao.User;
import com.iam.forum.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO validateUser(UserDTO userDTO) {
        try {
            User userResponse = userRepository.findById(userDTO.getUsername()).orElseThrow();
            if (userResponse.getPassword().equals(userDTO.getPassword())){
                return UserMapper.fromDao(userResponse);
            }else {
                throw new Exception();
            }
        }
        catch (Exception ex){
            return null;
        }
    }

    public UserDTO registerUser(UserDTO userDTO) {
        try {
            Optional<User> userResponse = userRepository.findById(userDTO.getUsername());
            if (!userResponse.isPresent()){
                User user = UserMapper.toDao(userDTO);
                userRepository.save(user);
                return userDTO;
            }else {
                throw new Exception();
            }
        }
        catch (Exception ex){
            return null;
        }
    }
}
