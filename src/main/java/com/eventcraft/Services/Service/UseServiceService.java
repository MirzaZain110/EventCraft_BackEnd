package com.eventcraft.Services.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.Service.ServicePictureRepository;
import com.eventcraft.Repository.Service.ServiceRepository;
import com.eventcraft.entities.Services.ServicePicture;
import com.eventcraft.entities.Services.UseService;

@Service
public class UseServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServicePictureRepository pictureRepository; // updated


    
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

        // Update basic attributes
        existingService.setServiceName(updatedService.getServiceName());
        existingService.setServiceType(updatedService.getServiceType());
        existingService.setServicePrice(updatedService.getServicePrice());
        existingService.setServiceCity(updatedService.getServiceCity());
        existingService.setServiceArea(updatedService.getServiceArea());
        existingService.setServiceCapacity(updatedService.getServiceCapacity());
        existingService.setServiceProvider(updatedService.getServiceProvider());

        // Update pictures
        if (updatedService.getPictures() != null) {
            // Clear existing pictures and add the new ones
            existingService.getPictures().clear();
            existingService.getPictures().addAll(updatedService.getPictures());

            // Ensure bidirectional relationship is maintained
            for (ServicePicture picture : existingService.getPictures()) {
                picture.setUseService(existingService);
            }
        }

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
    
    
    // images upload workers 
    public List<ServicePicture> getPicturesByServiceId(Long serviceId) {
        return pictureRepository.findByUseService_ServiceId(serviceId);
    }

    public ServicePicture addPictureToService(Long serviceId, ServicePicture picture) {
        UseService service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        picture.setUseService(service);
        return pictureRepository.save(picture);
    }

    public void deletePicture(Long pictureId) {
        pictureRepository.deleteById(pictureId);
    }
    // images worker end
}
