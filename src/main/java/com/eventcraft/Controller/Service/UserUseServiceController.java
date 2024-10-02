package com.eventcraft.Controller.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.Service.UserUseServiceService;
import com.eventcraft.entities.Services.UserUseService;

import java.util.List;

@RestController
@RequestMapping("/api/userServices")
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
        return ResponseEntity.ok(userServiceService.createUserService(userService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUseService> updateUserService(@PathVariable Long id, @RequestBody UserUseService userService) {
        return ResponseEntity.ok(userServiceService.updateUserService(id, userService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserService(@PathVariable Long id) {
        userServiceService.deleteUserService(id);
        return ResponseEntity.noContent().build();
    }
}
