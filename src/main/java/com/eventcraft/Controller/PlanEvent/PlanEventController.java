package com.eventcraft.Controller.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.DTO.EventResponseDto;
import com.eventcraft.Services.PlanEvent.PlanEventService;
import com.eventcraft.Services.PlanEvent.PlanEventServicesService;
import com.eventcraft.Services.Service.UserUseServiceService;
import com.eventcraft.entities.PlanEvent.PlanEvent;
import com.eventcraft.entities.PlanEvent.PlanEventServices;
import com.eventcraft.entities.Services.UserUseService;
import com.eventcraft.Controller.PlanEvent.EventRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/planEvents")
public class PlanEventController {

    @Autowired
    private PlanEventService planEventService;
    
    
    @Autowired
    private PlanEventServicesService planEventServicesService;

    @Autowired
    private UserUseServiceService userUseServiceService; // Ensure this is declared and autowired

    
    @GetMapping
    public ResponseEntity<List<PlanEvent>> getAllPlanEvents() {
        return ResponseEntity.ok(planEventService.getAllPlanEvents());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PlanEvent> getPlanEventById(@PathVariable Long id) {
//        return ResponseEntity.ok(planEventService.getPlanEventById(id));
//    }

    @PostMapping
    public ResponseEntity<PlanEvent> createPlanEvent(@RequestBody PlanEvent planEvent) {
        return ResponseEntity.ok(planEventService.createPlanEvent(planEvent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanEvent> updatePlanEvent(@PathVariable Long id, @RequestBody PlanEvent planEvent) {
        return ResponseEntity.ok(planEventService.updatePlanEvent(id, planEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanEvent(@PathVariable Long id) {
        planEventService.deletePlanEvent(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/byPlanEvent/{planEventId}")
    public ResponseEntity<List<PlanEventServices>> getServicesByPlanEvent(@PathVariable Long planEventId) {
        List<PlanEventServices> services = planEventServicesService.getServicesByPlanEvent(planEventId);
        return ResponseEntity.ok(services);
    }
//    @GetMapping("/user/{userId}/events")
//    public ResponseEntity<List<EventResponseDto>> getEventsByUserId(@PathVariable Long userId) {
//        List<PlanEvent> events = planEventService.getEventsByUserId(userId);
//        
//        if (events == null || events.isEmpty()) {
//            // Return an empty list if no events are found
//            return ResponseEntity.ok(new ArrayList<>());
//        }
//        
//        List<EventResponseDto> response = events.stream().map(event -> {
//            EventResponseDto dto = new EventResponseDto();
//            dto.setEventName(event.getPlanEventName());
//            dto.setDescription(event.getPlanEventDescription());
//            dto.setBudget(event.getPlanEventBudget());
//            dto.setUserId(event.getUser().getUserId());
//
//            List<PlanEventServices> services = planEventServicesService.getServicesByPlanEvent(event.getPlanEventId());
//            List<EventResponseDto.ServiceDetails> serviceDetails = new ArrayList<>();
//
//            for (PlanEventServices service : services) {
//                List<UserUseService> userUseServices = userUseServiceService.getByPlanEventService(service.getId());
//                for (UserUseService userUseService : userUseServices) {
//                    EventResponseDto.ServiceDetails detail = new EventResponseDto.ServiceDetails();
//                    detail.setServiceId(service.getService().getServiceId());
//                    detail.setServiceName(service.getService().getServiceName());
//                    detail.setNoOfPeople(userUseService.getNumberOfPeople());
//                    detail.setLocation(userUseService.getLocation());
//                    detail.setStatus(userUseService.getServiceStatus());
//                    detail.setServiceDateTime(userUseService.getServiceDateTime());
//                    detail.setServiceRating(userUseService.getServiceRating());
//                    serviceDetails.add(detail);
//                }
//            }
//
//            dto.setServices(serviceDetails);
//            return dto;
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.ok(response);
//    }
    
    
    @GetMapping("/user/{userId}/events")
    public ResponseEntity<List<EventRequestDto>> getEventsByUserId(@PathVariable Long userId) {
    	return ResponseEntity.ok(planEventService.getPlanEventByUserId(userId));
    	
    }
    
}

