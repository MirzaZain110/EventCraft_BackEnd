package com.eventcraft.Controller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eventcraft.Services.Service.UseServiceService;
import com.eventcraft.Services.Service.ServicePictureService;
import com.eventcraft.entities.Services.UseService;
import com.eventcraft.entities.Services.ServicePicture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class UseSeriveController {

    @Autowired
    private UseServiceService serviceService;

    @Autowired
    private ServicePictureService pictureService;

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

    // Get services by serviceProviderId
    @GetMapping("/serviceprovider/{serviceProviderId}")
    public ResponseEntity<List<UseService>> getServicesByServiceProviderId(@PathVariable Long serviceProviderId) {
        return ResponseEntity.ok(serviceService.getServicesByServiceProviderId(serviceProviderId));
    }

    // Upload a picture for a specific service
    @PostMapping("/{serviceId}/pictures")
    public ResponseEntity<ServicePicture> uploadPicture(
            @PathVariable Long serviceId,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(pictureService.uploadServiceImage(serviceId, file));
    }

    // Update a picture for a specific service
//    @PutMapping("/{serviceId}/pictures/{pictureId}")
//    public ResponseEntity<ServicePicture> updatePicture(
//            @PathVariable Long serviceId,
//            @PathVariable Long pictureId,
//            @RequestParam("file") MultipartFile file) {
//        return ResponseEntity.ok(pictureService.updateServiceImage(serviceId, pictureId, file));
//    }
    

    // Get all pictures for a specific service
    @GetMapping("/{serviceId}/pictures")
    public ResponseEntity<List<ServicePicture>> getServicePictures(@PathVariable Long serviceId) {
        return ResponseEntity.ok(pictureService.getServiceImages(serviceId));
    }
    
    @GetMapping("/images/{filename}") // updated the image name instead of url from service
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        Path imagePath = Paths.get("upload/images/service_images").resolve(filename);

        try {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust if needed
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    }  //http://localhost:8080/api/services/images/service_1_hallkarsaz.jpg 
    
    // Delete a picture for a specific service
//    @DeleteMapping("/{serviceId}/pictures/{pictureId}")
//    public ResponseEntity<Void> deletePicture(
//            @PathVariable Long serviceId,
//            @PathVariable Long pictureId) {
//        pictureService.deleteServiceImage(serviceId, pictureId);
//        return ResponseEntity.noContent().build();
//    }
}
