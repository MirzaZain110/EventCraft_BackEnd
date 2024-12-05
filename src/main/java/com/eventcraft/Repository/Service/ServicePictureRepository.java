package com.eventcraft.Repository.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventcraft.entities.Services.ServicePicture;

import java.util.List;

public interface ServicePictureRepository extends JpaRepository<ServicePicture, Long> {

    List<ServicePicture> findByUseService_ServiceId(Long serviceId); // Get pictures by service ID
}
