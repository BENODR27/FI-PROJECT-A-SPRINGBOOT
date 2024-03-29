package com.fiprojecta.projectaspringboot.service;

import java.util.List;

import com.fiprojecta.projectaspringboot.model.UserModel;

public interface UserService {
    public String createUser(UserModel userModel);

    public String updateUser(Long userId, UserModel userModel);

    public String deleteUser(Long userId);

    public UserModel getUserById(Long userId);

    public List<UserModel> getAllUsers();

    public UserModel getUserByUserName(String userName);
    
}
