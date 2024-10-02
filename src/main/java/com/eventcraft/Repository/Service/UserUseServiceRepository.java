package com.eventcraft.Repository.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcraft.entities.Services.UserUseService;

public interface UserUseServiceRepository extends JpaRepository<UserUseService, Long> {
}

