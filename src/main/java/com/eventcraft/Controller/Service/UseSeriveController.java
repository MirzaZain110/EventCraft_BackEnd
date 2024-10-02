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

    @GetMapping
    public ResponseEntity<List<UseService>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UseService> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @PostMapping
    public ResponseEntity<UseService> createService(@RequestBody UseService service) {
        return ResponseEntity.ok(serviceService.createService(service));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UseService> updateService(@PathVariable Long id, @RequestBody UseService service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
