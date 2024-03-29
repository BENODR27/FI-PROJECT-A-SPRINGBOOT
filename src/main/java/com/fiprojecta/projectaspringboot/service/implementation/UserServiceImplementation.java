package com.fiprojecta.projectaspringboot.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiprojecta.projectaspringboot.exception.CustomException.CustomNotFoundException;
import com.fiprojecta.projectaspringboot.model.UserModel;
import com.fiprojecta.projectaspringboot.repository.UserRepository;
import com.fiprojecta.projectaspringboot.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    @Override
    public String createUser(UserModel userModel) {
        userRepository.save(userModel);
        return "saved";
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "deleted";
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(Long userId) {

        if (userRepository.findById(userId).isEmpty())
            throw new CustomNotFoundException("user does not exist");

        return userRepository.findById(userId).get();
    }

    @Override
    public UserModel getUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    @Override
    public String updateUser(Long userId, UserModel userModel) {

        Optional<UserModel> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();

            // Update the properties of the existing user with the new values
            existingUser.setUserName(userModel.getUserName());
            existingUser.setUserEmail(userModel.getUserEmail());

            // Save the updated user entity back to the database
            userRepository.save(existingUser);

            return "updated";
        } else {
            // If user with given userId does not exist
            return "User not found";
        }
    }

}
