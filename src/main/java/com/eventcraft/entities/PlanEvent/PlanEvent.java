package com.eventcraft.entities.PlanEvent;


import com.eventcraft.entities.Users.User;

import jakarta.persistence.*;

@Entity
public class PlanEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planEventId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // References the User who is planning the event

    private String planEventName;
    private Double planEventBudget;
    private String planEventDescription;

    // Getters and Setters
    public Long getPlanEventId() {
        return planEventId;
    }

    public void setPlanEventId(Long planEventId) {
        this.planEventId = planEventId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlanEventName() {
        return planEventName;
    }

    public void setPlanEventName(String planEventName) {
        this.planEventName = planEventName;
    }

    public Double getPlanEventBudget() {
        return planEventBudget;
    }

    public void setPlanEventBudget(Double planEventBudget) {
        this.planEventBudget = planEventBudget;
    }

    public String getPlanEventDescription() {
        return planEventDescription;
    }

    public void setPlanEventDescription(String planEventDescription) {
        this.planEventDescription = planEventDescription;
    }
}

