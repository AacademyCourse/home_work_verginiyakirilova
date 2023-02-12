package com.example.home_work_module14.controller;

import com.example.home_work_module14.entity.User;
import com.example.home_work_module14.repository.UserRepository;
import com.example.home_work_module14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id){
        User userResult = new User();
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userResult = user.get();
        }

        return  userResult;
    }
    @PostMapping(path = "/add")
    public User createUser (@RequestBody User user){
       return userService.saveUser(user);
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable Long id){
         this.userService.deleteById(id);
        return String.format("User with %s id is deleted", id);
    }
}
