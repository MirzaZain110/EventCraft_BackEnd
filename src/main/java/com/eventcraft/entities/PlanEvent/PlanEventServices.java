package com.eventcraft.entities.PlanEvent;


import com.eventcraft.entities.Services.UseService;

import jakarta.persistence.*;

@Entity
@Table(name = "plan_event_services")
public class PlanEventServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_event_id", nullable = false)
    private PlanEvent planEvent;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private UseService service;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanEvent getPlanEvent() {
        return planEvent;
    }

    public void setPlanEvent(PlanEvent planEvent) {
        this.planEvent = planEvent;
    }

    public UseService getService() {
        return service;
    }

    public void setService(UseService service) {
        this.service = service;
    }
}

