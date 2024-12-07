package com.api.crud_java._4.controllers;

import com.api.crud_java._4.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserModel userService;


  @GetMapping
  public ArrayList<UserModel> getUsers() {
      return this.userService.getUsers();
  }

  @PostMapping
  public UserModel saveUser(@RequestBody UserModel user) {
      return this.userService.saveUser(user);
  }

  @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id")  Long id){
      return this.userService.getById(id);
  }

  @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id ){
  return this.userService.updateById(request, id);
  }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "User with id " + id + " deleted!";
        } else {
            return "Error, didn't find user with id " + id;
        }
    }

}
