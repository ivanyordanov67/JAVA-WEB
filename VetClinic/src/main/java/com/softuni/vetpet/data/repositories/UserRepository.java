package com.softuni.vetpet.data.repositories;

import com.softuni.vetpet.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

//    User findFirstByUsernameAndPassword(String username, String password);
    boolean existsUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
