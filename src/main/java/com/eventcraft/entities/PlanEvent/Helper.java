package com.eventcraft.entities.PlanEvent;


import com.eventcraft.entities.Users.User;

import jakarta.persistence.*;

@Entity
@Table(name = "helper")
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_event_id", nullable = false)
    private PlanEvent planEvent;

    @ManyToOne
    @JoinColumn(name = "helper_id", nullable = false)
    private User helper;  // References the helper user from the User table

    private String helperPrivileges;

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

    public User getHelper() {
        return helper;
    }

    public void setHelper(User helper) {
        this.helper = helper;
    }

    public String getHelperPrivileges() {
        return helperPrivileges;
    }

    public void setHelperPrivileges(String helperPrivileges) {
        this.helperPrivileges = helperPrivileges;
    }
}

