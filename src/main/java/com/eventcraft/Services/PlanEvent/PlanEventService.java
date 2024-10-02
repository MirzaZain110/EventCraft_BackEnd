package com.eventcraft.Services.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcraft.Repository.PlanEvent.PlanEventRepository;
import com.eventcraft.entities.PlanEvent.PlanEvent;

import java.util.List;

@Service
public class PlanEventService {

    @Autowired
    private PlanEventRepository planEventRepository;

    public List<PlanEvent> getAllPlanEvents() {
        return planEventRepository.findAll();
    }

    public PlanEvent getPlanEventById(Long id) {
        return planEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlanEvent not found"));
    }

    public PlanEvent createPlanEvent(PlanEvent planEvent) {
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
}

