package com.eventcraft.Services.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.Service.ServiceRepository;
import com.eventcraft.entities.Services.UseService;

@Service
public class UseServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<UseService> getAllServices() {
        return serviceRepository.findAll();
    }

    public UseService getServiceById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public UseService createService(UseService service) {
        return serviceRepository.save(service);
    }

    public UseService updateService(Long id, UseService updatedService) {
        UseService existingService = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setServiceName(updatedService.getServiceName());
        existingService.setServiceType(updatedService.getServiceType());
        existingService.setServicePrice(updatedService.getServicePrice());
        existingService.setServiceProvider(updatedService.getServiceProvider());

        return serviceRepository.save(existingService);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}

