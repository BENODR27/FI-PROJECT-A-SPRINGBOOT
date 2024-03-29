package com.fiprojecta.projectaspringboot.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiprojecta.projectaspringboot.model.UserModel;
import com.fiprojecta.projectaspringboot.response.ResponseHandler;
import com.fiprojecta.projectaspringboot.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserRestController {

    UserService userService;

    @GetMapping("/{userId}")
    public UserModel getUserById(@PathVariable("userId") Long userId) {

        return userService.getUserById(userId);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {

        return ResponseHandler.responseBuilder(" Details are here",
                HttpStatus.OK, userService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {

        String result = userService.createUser(userModel);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "deleted";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Long userId, @RequestBody UserModel userModel) {
        userService.updateUser(userId, userModel);
        return "updated";
    }

    @GetMapping("/fetch/{userName}")
    public UserModel getByUserName(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

}
