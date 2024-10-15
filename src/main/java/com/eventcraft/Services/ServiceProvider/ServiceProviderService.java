package com.eventcraft.Services.ServiceProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.DTO.ServiceProvider.ServiceProviderDTO;
import com.eventcraft.Repository.ServiceProvider.ServiceProviderRepository;
import com.eventcraft.entities.ServiceProvider.ServiceProvider;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    public ServiceProvider getServiceProviderById(Long id) {
        return serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceProvider not found"));
    }

    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    public void deleteServiceProvider(Long id) {
        serviceProviderRepository.deleteById(id);
    }

    public ServiceProvider updateServiceProvider(Long id, ServiceProvider updatedServiceProvider) {
        Optional<ServiceProvider> optionalServiceProvider = serviceProviderRepository.findById(id);

        if (optionalServiceProvider.isPresent()) {
            ServiceProvider existingServiceProvider = optionalServiceProvider.get();
            existingServiceProvider.setServiceProviderName(updatedServiceProvider.getServiceProviderName());
            existingServiceProvider.setServiceProviderEmail(updatedServiceProvider.getServiceProviderEmail());
            existingServiceProvider.setServiceProviderPassword(updatedServiceProvider.getServiceProviderPassword());
            existingServiceProvider.setServiceProviderPhone(updatedServiceProvider.getServiceProviderPhone());
            existingServiceProvider.setServiceProviderLocation(updatedServiceProvider.getServiceProviderLocation());

            return serviceProviderRepository.save(existingServiceProvider);
        } else {
            throw new RuntimeException("ServiceProvider not found with id: " + id);
        }
    }

    // DTO to Entity Conversion
    public ServiceProvider convertToEntity(ServiceProviderDTO dto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setServiceProviderId(dto.getServiceProviderId());
        serviceProvider.setServiceProviderName(dto.getServiceProviderName());
        serviceProvider.setServiceProviderEmail(dto.getServiceProviderEmail());
        serviceProvider.setServiceProviderPhone(dto.getServiceProviderPhone());
        serviceProvider.setServiceProviderLocation(dto.getServiceProviderLocation());
        return serviceProvider;
    }

    // Entity to DTO Conversion
    public ServiceProviderDTO convertToDTO(ServiceProvider serviceProvider) {
        ServiceProviderDTO dto = new ServiceProviderDTO();
        dto.setServiceProviderId(serviceProvider.getServiceProviderId());
        dto.setServiceProviderName(serviceProvider.getServiceProviderName());
        dto.setServiceProviderEmail(serviceProvider.getServiceProviderEmail());
        dto.setServiceProviderPhone(serviceProvider.getServiceProviderPhone());
        dto.setServiceProviderLocation(serviceProvider.getServiceProviderLocation());
        return dto;
    }
}
