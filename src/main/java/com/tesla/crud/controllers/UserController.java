package com.tesla.crud.controllers;

import com.tesla.crud.models.UserModel;
import com.tesla.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/getUsers")
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path="/saveUser")
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @GetMapping(path="/getUser/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping(path="/updateUser/{id}")
    public UserModel updateUserById(@RequestBody UserModel user, @PathVariable Long id){
        return userService.UpdateById(user, id);
    }

    @DeleteMapping(path="/deleteUser/{id}")
    public String deleteById(@PathVariable Long id){
        boolean ok = userService.deleteById(id);

        if(ok){
            return "User with id " + id + " deleted";
        } else {
            return "User with id " + id + " not found";
        }
    }


}
