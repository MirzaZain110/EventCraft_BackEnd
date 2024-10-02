package com.eventcraft.Controller.ServiceProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.ServiceProvider.ServiceProviderService;
import com.eventcraft.entities.ServiceProvider.ServiceProvider;

import java.util.List;

@RestController
@RequestMapping("/api/serviceProviders")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        return ResponseEntity.ok(serviceProviderService.getAllServiceProviders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceProviderService.getServiceProviderById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return ResponseEntity.ok(serviceProviderService.createServiceProvider(serviceProvider));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(
            @PathVariable Long id, 
            @RequestBody ServiceProvider updatedServiceProvider) {
        ServiceProvider serviceProvider = serviceProviderService.updateServiceProvider(id, updatedServiceProvider);
        return ResponseEntity.ok(serviceProvider);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.noContent().build();
    }
}

