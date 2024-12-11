package com.eventcraft.Services.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.PlanEvent.PlanEventServicesRepository;
import com.eventcraft.entities.PlanEvent.PlanEventServices;
import com.eventcraft.Repository.Service.ServiceRepository;

import java.util.List;

@Service
public class PlanEventServicesService {

    @Autowired
    private PlanEventServicesRepository planEventServicesRepository;
   
    @Autowired
    private ServiceRepository serviceRepository;

    public List<PlanEventServices> getAllPlanEventServices() {
        return planEventServicesRepository.findAll();
    }

    public PlanEventServices getPlanEventServiceById(Long id) {
        return planEventServicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlanEventServices not found"));
    }
//    public Service getServiceById(Long serviceId) {
//        return serviceRepository.findById(serviceId)
//                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + serviceId));
//    }

    public PlanEventServices createPlanEventService(PlanEventServices planEventServices) {
        return planEventServicesRepository.save(planEventServices);
    }

    public PlanEventServices updatePlanEventService(Long id, PlanEventServices updatedPlanEventServices) {
        PlanEventServices existingPlanEventService = planEventServicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlanEventServices not found"));

        existingPlanEventService.setPlanEvent(updatedPlanEventServices.getPlanEvent());
        existingPlanEventService.setService(updatedPlanEventServices.getService());

        return planEventServicesRepository.save(existingPlanEventService);
    }

    public void deletePlanEventService(Long id) {
        planEventServicesRepository.deleteById(id);
    }
    
    // get the list of plan event services 
    public List<PlanEventServices> getServicesByPlanEvent(Long planEventId) {
        return planEventServicesRepository.findByPlanEvent_PlanEventId(planEventId);
    }
}

