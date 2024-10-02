package com.eventcraft.Controller.PlanEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.PlanEvent.PlanEventService;
import com.eventcraft.entities.PlanEvent.PlanEvent;

import java.util.List;

@RestController
@RequestMapping("/api/planEvents")
public class PlanEventController {

    @Autowired
    private PlanEventService planEventService;

    @GetMapping
    public ResponseEntity<List<PlanEvent>> getAllPlanEvents() {
        return ResponseEntity.ok(planEventService.getAllPlanEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanEvent> getPlanEventById(@PathVariable Long id) {
        return ResponseEntity.ok(planEventService.getPlanEventById(id));
    }

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
}

