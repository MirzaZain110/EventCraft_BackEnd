package com.eventcraft.Controller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.Service.UseServiceService;
import com.eventcraft.entities.Services.UseService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class UseSeriveController {

    @Autowired
    private UseServiceService serviceService;

    // Get all services
    @GetMapping
    public ResponseEntity<List<UseService>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    // Get a service by ID
    @GetMapping("/{id}")
    public ResponseEntity<UseService> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    // Create a new service
    @PostMapping
    public ResponseEntity<UseService> createService(@RequestBody UseService service) {
        return ResponseEntity.ok(serviceService.createService(service));
    }

    // Update an existing service
    @PutMapping("/{id}")
    public ResponseEntity<UseService> updateService(@PathVariable Long id, @RequestBody UseService service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    // Delete a service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }

    // Search services by serviceType
    @GetMapping("/search/type")
    public ResponseEntity<List<UseService>> getServicesByType(@RequestParam String type) {
        return ResponseEntity.ok(serviceService.getServicesByType(type));
    }

    // Search services by serviceCity
    @GetMapping("/search/city")
    public ResponseEntity<List<UseService>> getServicesByCity(@RequestParam String city) {
        return ResponseEntity.ok(serviceService.getServicesByCity(city));
    }

    // Search services by serviceCity and serviceType
    @GetMapping("/search")
    public ResponseEntity<List<UseService>> getServicesByCityAndType(
            @RequestParam String city, 
            @RequestParam String type) {
        return ResponseEntity.ok(serviceService.getServicesByCityAndType(city, type));
    }
    
 // New endpoint to get services by serviceProviderId
    @GetMapping("/serviceprovider/{serviceProviderId}")
    public ResponseEntity<List<UseService>> getServicesByServiceProviderId(@PathVariable Long serviceProviderId) {
        return ResponseEntity.ok(serviceService.getServicesByServiceProviderId(serviceProviderId));
    }
    
}
