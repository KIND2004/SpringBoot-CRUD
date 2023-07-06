package com.abdullah.firstsbp.controllers;

import com.abdullah.firstsbp.entity.User;
import com.abdullah.firstsbp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Saved Successfully!");
    }

    @GetMapping("/readUsers")
    public ResponseEntity<?> readUsers() {
        return userService.readUser();
    }

    @GetMapping("/readUsersById/{id}")
    public ResponseEntity<?> readUsersById(@PathVariable("id") long id) {
        return userService.readUserById(id);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        ResponseEntity updateUser = userService.updateUser(user);
        return updateUser;
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        ResponseEntity deleteUser = userService.deleteUser(id);
        return deleteUser;
    }

}
