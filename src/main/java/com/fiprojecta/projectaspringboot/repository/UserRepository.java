package com.fiprojecta.projectaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiprojecta.projectaspringboot.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserName(String userName);

}
