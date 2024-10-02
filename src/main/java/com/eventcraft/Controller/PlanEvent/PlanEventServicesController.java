package com.eventcraft.Controller.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.PlanEvent.PlanEventServicesService;
import com.eventcraft.entities.PlanEvent.PlanEventServices;

import java.util.List;

@RestController
@RequestMapping("/api/planEventServices")
public class PlanEventServicesController {

    @Autowired
    private PlanEventServicesService planEventServicesService;

    @GetMapping
    public ResponseEntity<List<PlanEventServices>> getAllPlanEventServices() {
        return ResponseEntity.ok(planEventServicesService.getAllPlanEventServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanEventServices> getPlanEventServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(planEventServicesService.getPlanEventServiceById(id));
    }

    @PostMapping
    public ResponseEntity<PlanEventServices> createPlanEventService(@RequestBody PlanEventServices planEventServices) {
        return ResponseEntity.ok(planEventServicesService.createPlanEventService(planEventServices));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanEventServices> updatePlanEventService(@PathVariable Long id, @RequestBody PlanEventServices planEventServices) {
        return ResponseEntity.ok(planEventServicesService.updatePlanEventService(id, planEventServices));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanEventService(@PathVariable Long id) {
        planEventServicesService.deletePlanEventService(id);
        return ResponseEntity.noContent().build();
    }
}

