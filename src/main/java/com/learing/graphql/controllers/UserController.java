package com.learing.graphql.controllers;

import com.learing.graphql.entities.User;
import com.learing.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String name,@Argument String phone, @Argument String email, @Argument String password){
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }
    @MutationMapping
    public User updateUser(@Argument int userId,@Argument String name,@Argument String phone, @Argument String email, @Argument String password){
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.updateUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
