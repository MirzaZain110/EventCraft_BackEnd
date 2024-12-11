package com.eventcraft.Services.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import  com.eventcraft.Controller.PlanEvent.EventRequestDto;
import com.eventcraft.Controller.PlanEvent.EventRequestDto.ServiceDetails;

import org.springframework.stereotype.Service;
import com.eventcraft.Repository.PlanEvent.PlanEventRepository;
import com.eventcraft.entities.PlanEvent.PlanEvent;
import com.eventcraft.Repository.UserRepository.UserRepository;
import com.eventcraft.entities.Users.User;
import com.eventcraft.Repository.PlanEvent.PlanEventServicesRepository;
import com.eventcraft.entities.PlanEvent.PlanEventServices;
import com.eventcraft.entities.Services.UserUseService;
import com.eventcraft.Repository.Service.UserUseServiceRepository;
import  com.eventcraft.Repository.PlanEvent.PlanEventServicesRepository;
import com.eventcraft.entities.PlanEvent.PlanEventServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanEventService {

    @Autowired
    private PlanEventRepository planEventRepository;
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlanEventServicesRepository planEventServiceRepo;
    
    @Autowired
    private UserUseServiceRepository userUseServiceRepository;
    
    @Autowired
    private PlanEventServicesRepository planEventServicesRepository;
    
    // add use service repo.

    public List<PlanEvent> getAllPlanEvents() {
        return planEventRepository.findAll();
    }

    
    public List<EventRequestDto> getPlanEventByUserId(Long userId) {
    Optional<User> user =	userRepository.findById(userId);
    
    List<ServiceDetails> services = new ArrayList<>();
    if (user.isPresent()) {
        User user2 = user.get();
        List<PlanEvent> planEvent = planEventRepository.findByUser_UserId(userId);
        List<PlanEventServices> list = new ArrayList<>();
        
        List<UserUseService> list2 = new ArrayList<>(); // service list
        
        
        for (PlanEvent event : planEvent) {
       
            List<UserUseService> dtos =null;;
			try {
				dtos = userUseServiceRepository.findByPlanEvent_PlanEventId(event.getPlanEventId());
			
			} catch (Exception e) {
		
				e.printStackTrace();
			}
		
            
            if (dtos != null) {
                list2.addAll(dtos);
            }
            
            
        }
        
        List<PlanEventServices> PEservicelist = new ArrayList();
    for(int j=0;j<planEvent.size();j++) {
        Optional<PlanEventServices> planEventServices = planEventServicesRepository.findById(planEvent.get(j).getPlanEventId());
       if(planEventServices.isPresent()) {
    	   PlanEventServices planEventServices2=planEventServices.get();
    	   PEservicelist.add(planEventServices2);
    	   
    	   List<UserUseService> userUseService=  userUseServiceRepository.findByPlanEventService_Id(planEventServices2.getId());
    	   
    	 for(int i=0;i<userUseService.size();i++)
    	 {
    	    services.add(new ServiceDetails(userUseService.get(i).getPlanedEventService().getService().getServiceId(), 
    	    		userUseService.get(i).getNumberOfPeople(), userUseService.get(i).getLocation(),
    	    		userUseService.get(i).getServiceStatus(), userUseService.get(i).getServiceDateTime(),
    	    		userUseService.get(i).getServiceRating()));
    	   
    	 } 
    	   
       }
    }
       

//        List<PlanEventServices> dto;
        
        for (PlanEvent event : planEvent) {
            
            List<PlanEventServices> dto2 = planEventServiceRepo.findByPlanEvent_PlanEventId(event.getPlanEventId());
           
            if (dto2 != null) {
                list.addAll(dto2);
            }
        }
    
        
        
        
    
    
    List<EventRequestDto> event = new ArrayList();
    
    List<EventRequestDto> event2 = new ArrayList();
    
//    event2.add(new )
   // instead of planevent  get data by list2.
   
 
//    // Populate the services list as needed
//    services.add(new ServiceDetails(Long.valueOf(1), list2.get(0).getNumberOfPeople(), list2.get(0).getLocation(),
//    		list2.get(0).getServiceStatus(), list2.get(0).getServiceDateTime(), list2.get(0).getServiceRating()));
    event.add(new EventRequestDto(
        planEvent.get(0).getPlanEventName(),
        planEvent.get(0).getPlanEventDescription(),
        planEvent.get(0).getPlanEventBudget(),
        planEvent.get(0).getUser().getUserId(),
        services
    ));

//   event.add(new EventRequestDto(planEvent.get(1).getPlanEventName(),
//		   planEvent.get(1).getPlanEventDescription()
//		   ,planEvent.get(1).getPlanEventBudget(), planEvent.get(1).getUser().getUserId()));
//  

    
    
    
   
    
    	return event;
    }
    	return null;
    	
    	
    }

    public PlanEvent createPlanEvent(PlanEvent planEvent) {
    	 // get use service by id. -> get
    	//save plan event data. -> save -> forigen key 
    	// save 
    	
    	
        return planEventRepository.save(planEvent);
    }

    public PlanEvent updatePlanEvent(Long id, PlanEvent updatedPlanEvent) {
        PlanEvent existingPlanEvent = planEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlanEvent not found"));

        existingPlanEvent.setPlanEventName(updatedPlanEvent.getPlanEventName());
        existingPlanEvent.setPlanEventBudget(updatedPlanEvent.getPlanEventBudget());
        existingPlanEvent.setPlanEventDescription(updatedPlanEvent.getPlanEventDescription());

        return planEventRepository.save(existingPlanEvent);
    }

    public void deletePlanEvent(Long id) {
        planEventRepository.deleteById(id);
    }
    
//    public List<PlanEvent> getEventsByUserId(Long userId) {
//        return planEventRepository.findBy_UserId(userId);
//    }
    
}

