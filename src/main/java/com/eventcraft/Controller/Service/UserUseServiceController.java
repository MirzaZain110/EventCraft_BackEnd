package com.eventcraft.Controller.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.Service.UserUseServiceService;
import com.eventcraft.entities.Services.UserUseService;
import com.eventcraft.entities.Services.UseService;
import java.util.List;

@RestController
@RequestMapping("/api/userEventServices")
public class UserUseServiceController {

    @Autowired
    private UserUseServiceService userServiceService;

    @GetMapping
    public ResponseEntity<List<UserUseService>> getAllUserServices() {
        return ResponseEntity.ok(userServiceService.getAllUserServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserUseService> getUserServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceService.getUserServiceById(id));
    }

    @PostMapping
    public ResponseEntity<UserUseService> createUserService(@RequestBody UserUseService userService) {
//    	validateServiceDetails(userService);
        return ResponseEntity.ok(userServiceService.createUserService(userService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUseService> updateUserService(@PathVariable Long id, @RequestBody UserUseService userService) {
//    	validateServiceDetails(userService);
    	return ResponseEntity.ok(userServiceService.updateUserService(id, userService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserService(@PathVariable Long id) {
        userServiceService.deleteUserService(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/byPlanEventService/{planEventServiceId}")
    public ResponseEntity<List<UserUseService>> getUserServicesByPlanEventService(@PathVariable Long planEventServiceId) {
        List<UserUseService> userServices = userServiceService.getByPlanEventService(planEventServiceId);
        return ResponseEntity.ok(userServices);
    }
    
    
    // Validation logic based on `serviceType`
//    private void validateServiceDetails(UserUseService userService) {
//        UseService service = userService.getService();
//        if (service == null) {
//            throw new IllegalArgumentException("Service must be provided.");
//        }
//
//        String serviceType = service.getServiceType();
//        if ("catering".equalsIgnoreCase(serviceType) || "venue".equalsIgnoreCase(serviceType) && userService.getNumberOfPeople() == null) {
//            throw new IllegalArgumentException("Number of people is required for catering services.");
//        }
//
//        if ("decoration".equalsIgnoreCase(serviceType) || "transportation".equalsIgnoreCase(serviceType) && userService.getLocation() == null) {
//            throw new IllegalArgumentException("Location is required for venue services.");
//        }
//    }
    
}
