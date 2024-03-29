package com.fiprojecta.projectaspringboot.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fiprojecta.projectaspringboot.model.UserModel;
import com.fiprojecta.projectaspringboot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component

public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() <= 0) {
            UserModel userModel = new UserModel();
            userModel.setUserName("name");
            userModel.setUserEmail("mail@mail.com");
            userRepository.save(userModel);
        }

    }

}
