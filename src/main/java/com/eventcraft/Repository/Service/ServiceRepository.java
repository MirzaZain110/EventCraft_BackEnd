package com.eventcraft.Repository.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcraft.entities.Services.UseService;

	
public interface ServiceRepository extends JpaRepository<UseService, Long> {
}
