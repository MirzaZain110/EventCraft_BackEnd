package com.eventcraft.Controller.ServiceProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.DTO.ServiceProvider.ServiceProviderDTO;
import com.eventcraft.Services.ServiceProvider.ServiceProviderService;

import com.eventcraft.entities.ServiceProvider.ServiceProvider;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/serviceProviders")

//@CrossOrigin(origins = "*") 
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping
    public ResponseEntity<List<ServiceProviderDTO>> getAllServiceProviders() {
        List<ServiceProvider> serviceProviders = serviceProviderService.getAllServiceProviders();
        List<ServiceProviderDTO> serviceProviderDTOs = serviceProviders.stream()
                .map(serviceProviderService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(serviceProviderDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> getServiceProviderById(@PathVariable Long id) {
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
        return ResponseEntity.ok(serviceProviderService.convertToDTO(serviceProvider));
    }

    @PostMapping
    public ResponseEntity<ServiceProviderDTO> createServiceProvider(@RequestBody ServiceProviderDTO serviceProviderDTO) {
        ServiceProvider serviceProvider = serviceProviderService.convertToEntity(serviceProviderDTO);
        ServiceProvider createdServiceProvider = serviceProviderService.createServiceProvider(serviceProvider);
        return ResponseEntity.ok(serviceProviderService.convertToDTO(createdServiceProvider));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> updateServiceProvider(
            @PathVariable Long id,
            @RequestBody ServiceProviderDTO serviceProviderDTO) {
        ServiceProvider updatedServiceProvider = serviceProviderService.updateServiceProvider(id, serviceProviderService.convertToEntity(serviceProviderDTO));
        return ResponseEntity.ok(serviceProviderService.convertToDTO(updatedServiceProvider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<ServiceProviderDTO> login(@RequestBody ServiceProviderDTO loginRequest) {
        try {
            ServiceProvider serviceProvider = serviceProviderService.authenticate(
                    loginRequest.getServiceProviderEmail(),
                    loginRequest.getServiceProviderPassword());
            return ResponseEntity.ok(serviceProviderService.convertToDTO(serviceProvider));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}
