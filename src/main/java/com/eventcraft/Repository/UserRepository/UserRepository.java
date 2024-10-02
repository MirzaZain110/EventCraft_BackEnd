package com.eventcraft.Repository.UserRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.eventcraft.entities.Users.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);
}
