package com.learing.graphql.services;

import com.learing.graphql.entities.User;
import com.learing.graphql.helper.ExceptionHelper;
import com.learing.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // creating user
    public User createUser(User user){
        return userRepo.save(user);
    }
    // getting all users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    // getting single user
    public User getUser(int userId){
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }
    // updating user
    public User updateUser(User user){
        User userFromDb = userRepo.findById(user.getUserId()).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        if(null != user.getName()) {
            userFromDb.setName(user.getName());
        }
        if(null != user.getPhone()) {
            userFromDb.setPhone(user.getPhone());
        }
        if(null != user.getEmail()) {
            userFromDb.setEmail(user.getEmail());
        }
        if(null != user.getPassword()) {
            userFromDb.setPassword(user.getPassword());
        }
        return userRepo.save(userFromDb);
    }
    // deleting user
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
