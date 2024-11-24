package com.eventcraft.Repository.ServiceProvider;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcraft.entities.ServiceProvider.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    ServiceProvider findByserviceProviderEmail(String serviceProviderEmail);
}
