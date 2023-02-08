package com.example.home_work_module14.service;

import com.example.home_work_module14.entity.User;
import com.example.home_work_module14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser (User user){
        User userToBeCreated = new User();
        userToBeCreated.setFirst_name(user.getFirst_name());
        userToBeCreated.setLast_name(user.getLast_name());
        userToBeCreated.setPhone_number(user.getPhone_number());
        userToBeCreated.setEmail(user.getEmail());
        userToBeCreated.setCreatedAt(user.getCreatedAt());

        return this.userRepository.save(userToBeCreated);
    }

    public User getUserById(Long id){
     return this.userRepository.findById(id).get();
    }

    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }
}
