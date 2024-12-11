package com.eventcraft.Controller;
//
//import com.eventcraft.entities.PlanEvent.PlanEvent;
//import com.eventcraft.entities.PlanEvent.PlanEventServices;
//import com.eventcraft.entities.Services.UserUseService;
//import com.eventcraft.Services.PlanEvent.PlanEventService;
//import com.eventcraft.Services.PlanEvent.PlanEventServicesService;
//import com.eventcraft.Services.Service.UserUseServiceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/events")
//public class EventController {
//
//    @Autowired
//    private PlanEventService planEventService;
//
//    @Autowired
//    private PlanEventServicesService planEventServicesService;
//
//    @Autowired
//    private UserUseServiceService userUseServiceService;
//
//    // Endpoint to create an event
//    @PostMapping("/create")
//    public ResponseEntity<PlanEvent> createEvent(@RequestBody PlanEvent planEvent) {
//        PlanEvent createdEvent = planEventService.createPlanEvent(planEvent);
//        return ResponseEntity.ok(createdEvent);
//    }
//
//    // Endpoint to assign services to an event
////    @PostMapping("/{eventId}/assign-services")
////    public ResponseEntity<List<PlanEventServices>> assignServices(
////            @PathVariable Long eventId,
////            @RequestBody List<Long> serviceIds) {
////
////        PlanEvent planEvent = planEventService.getPlanEventById(eventId);
////        if (planEvent == null) {
////            return ResponseEntity.badRequest().build();
////        }
////
////        List<PlanEventServices> assignedServices = serviceIds.stream().map(serviceId -> {
////            PlanEventServices planEventServices = new PlanEventServices();
////            planEventServices.setPlanEvent(planEvent);
////            planEventServices.setService(planEventServicesService.getPlanEventServiceById(serviceId).getService());
////            return planEventServicesService.createPlanEventService(planEventServices);
////        }).toList();
////
////        return ResponseEntity.ok(assignedServices);
////    }
// // Endpoint to assign services to an event
////    @PostMapping("/{eventId}/assign-services")
////    public ResponseEntity<List<PlanEventServices>> assignServices(
////            @PathVariable Long eventId,
////            @RequestBody List<Long> serviceIds) {
////
////        PlanEvent planEvent = planEventService.getPlanEventById(eventId);
////        if (planEvent == null) {
////            return ResponseEntity.badRequest().body(null);
////        }
////
////        // Create and assign PlanEventServices for each Service ID
////        List<PlanEventServices> assignedServices = serviceIds.stream().map(serviceId -> {
////            PlanEventServices planEventServices = new PlanEventServices();
////            planEventServices.setPlanEvent(planEvent);
////            planEventServices.setService(planEventServicesService.getServiceById(serviceId)); // Fetch Service directly
////            return planEventServicesService.createPlanEventService(planEventServices);
////        }).toList();
////
////        return ResponseEntity.ok(assignedServices);
////    }
//
//
//    // Endpoint to add service-specific details for an event
//    @PostMapping("/{eventId}/services/details")
//    public ResponseEntity<List<UserUseService>> addServiceDetails(
//            @PathVariable Long eventId,
//            @RequestBody List<UserUseService> serviceDetails) {
//
//        List<UserUseService> createdDetails = serviceDetails.stream().map(userService -> {
//            PlanEventServices planEventServices = planEventServicesService
//                    .getPlanEventServiceById(userService.getPlanedEventService().getId());
//            userService.setPlanEventService(planEventServices);
//            return userUseServiceService.createUserService(userService);
//        }).toList();
//
//        return ResponseEntity.ok(createdDetails);
//    }
//
//    // Endpoint to retrieve all services and their details for an event
//    @GetMapping("/{eventId}/services")
//    public ResponseEntity<List<PlanEventServices>> getEventServices(@PathVariable Long eventId) {
//        List<PlanEventServices> services = planEventServicesService.getServicesByPlanEvent(eventId);
//        return ResponseEntity.ok(services);
//    }
//}

//package com.eventcraft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Controller.PlanEvent.EventRequestDto;
import com.eventcraft.DTO.*;
import com.eventcraft.Services.PlanEvent.PlanEventService;
import com.eventcraft.Services.PlanEvent.PlanEventServicesService;
import com.eventcraft.Services.Service.UserUseServiceService;
import com.eventcraft.entities.PlanEvent.PlanEvent;
import com.eventcraft.entities.PlanEvent.PlanEventServices;
import com.eventcraft.entities.Services.UseService;
import com.eventcraft.entities.Services.UserUseService;
import com.eventcraft.entities.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private PlanEventService planEventService;

    @Autowired
    private PlanEventServicesService planEventServicesService;

    @Autowired
    private UserUseServiceService userUseServiceService;

    // Create Event and Related Data
    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody EventRequestDto request) {
        // Step 1: Save PlanEvent
        PlanEvent planEvent = new PlanEvent();
        planEvent.setPlanEventName(request.getEventName());
        planEvent.setPlanEventDescription(request.getDescription());
        planEvent.setPlanEventBudget(request.getBudget());
        planEvent.setUser(new User(request.getUserId())); // Assuming a user object is constructed with ID

        PlanEvent savedEvent = planEventService.createPlanEvent(planEvent);

        // Step 2: Save PlanEventServices and UserUseService
        List<EventRequestDto.ServiceDetails> services = request.getServices();
        for (EventRequestDto.ServiceDetails serviceDetail : services) {
            PlanEventServices planEventService = new PlanEventServices();
            planEventService.setPlanEvent(savedEvent);
            planEventService.setService(new UseService(serviceDetail.getServiceId())); // Assuming UseService has a constructor with ID
            PlanEventServices savedService = planEventServicesService.createPlanEventService(planEventService);

            // Save UserUseService details
            UserUseService userUseService = new UserUseService();
            userUseService.setPlanEvent(savedEvent);
            userUseService.setPlanEventService(savedService);
            userUseService.setLocation(serviceDetail.getLocation());
            userUseService.setNumberOfPeople(serviceDetail.getNoOfPeople());
            userUseService.setServiceStatus(serviceDetail.getStatus());
            userUseService.setServiceDateTime(serviceDetail.getServiceDateTime());
            userUseService.setServiceRating(serviceDetail.getServiceRating());
            //add the plan event service 
            userUseServiceService.createUserService(userUseService);
        }

        return ResponseEntity.ok("Event and services created successfully!");
    }

    // Retrieve All Data for an Event
   

}
