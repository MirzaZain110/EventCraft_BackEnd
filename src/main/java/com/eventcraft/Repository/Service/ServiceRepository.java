package com.eventcraft.Repository.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.eventcraft.entities.Services.UseService;

import java.util.List;

public interface ServiceRepository extends JpaRepository<UseService, Long> {

    // List service provider useservices 
	List<UseService> findByServiceProvider_ServiceProviderId(Long serviceProviderId);
	
	List<UseService> findByServiceType(String serviceType); // Search by serviceType

    List<UseService> findByServiceCity(String serviceCity); // Search by serviceCity

    @Query("SELECT s FROM UseService s WHERE s.serviceCity = :city AND s.serviceType = :type")
    List<UseService> findByCityAndType(@Param("city") String city, @Param("type") String type);
}
