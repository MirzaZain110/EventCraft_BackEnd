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
        existingService.setServiceCity(updatedService.getServiceCity());
        existingService.setServiceArea(updatedService.getServiceArea());
        existingService.setServiceCapacity(updatedService.getServiceCapacity());
        existingService.setServiceProvider(updatedService.getServiceProvider());

        return serviceRepository.save(existingService);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public List<UseService> getServicesByType(String serviceType) {
        return serviceRepository.findByServiceType(serviceType);
    }

    public List<UseService> getServicesByCity(String serviceCity) {
        return serviceRepository.findByServiceCity(serviceCity);
    }

    public List<UseService> getServicesByCityAndType(String city, String type) {
        return serviceRepository.findByCityAndType(city, type);
    }
    
 // New method to get services by serviceProviderId
    public List<UseService> getServicesByServiceProviderId(Long serviceProviderId) {
        return serviceRepository.findByServiceProvider_ServiceProviderId(serviceProviderId);
    }
}
