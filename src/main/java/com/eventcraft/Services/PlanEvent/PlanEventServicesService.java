package com.eventcraft.Services.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.PlanEvent.PlanEventServicesRepository;
import com.eventcraft.entities.PlanEvent.PlanEventServices;

import java.util.List;

@Service
public class PlanEventServicesService {

    @Autowired
    private PlanEventServicesRepository planEventServicesRepository;

    public List<PlanEventServices> getAllPlanEventServices() {
        return planEventServicesRepository.findAll();
    }

    public PlanEventServices getPlanEventServiceById(Long id) {
        return planEventServicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlanEventServices not found"));
    }

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
}

