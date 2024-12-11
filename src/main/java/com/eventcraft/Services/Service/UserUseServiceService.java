package com.eventcraft.Services.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.Service.UserUseServiceRepository;
import com.eventcraft.entities.Services.UserUseService;

import java.util.List;

@Service
public class UserUseServiceService {

    @Autowired
    private UserUseServiceRepository userServiceRepository;

    public List<UserUseService> getAllUserServices() {
        return userServiceRepository.findAll();
    }

    public UserUseService getUserServiceById(Long id) {
        return userServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Service not found"));
    }

    public UserUseService createUserService(UserUseService userService) {
        return userServiceRepository.save(userService);
    }

    public UserUseService updateUserService(Long id, UserUseService updatedUserService) {
        UserUseService existingUserService = userServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Service not found"));

        existingUserService.setServiceStatus(updatedUserService.getServiceStatus());
        existingUserService.setServiceDateTime(updatedUserService.getServiceDateTime());
        existingUserService.setServiceRating(updatedUserService.getServiceRating());

        return userServiceRepository.save(existingUserService);
    }

    public void deleteUserService(Long id) {
        userServiceRepository.deleteById(id);
    }

    public List<UserUseService> getByPlanEventService(Long planEventServiceId) {
        return userServiceRepository.findByPlanEventService_Service_ServiceId(planEventServiceId);
    }
    
}
