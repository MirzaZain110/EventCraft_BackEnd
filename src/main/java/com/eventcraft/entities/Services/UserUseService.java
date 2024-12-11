package com.eventcraft.entities.Services;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.eventcraft.entities.PlanEvent.*;
@Entity
public class UserUseService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "plan_event_id")
    private PlanEvent planEvent; 


    @ManyToOne
    @JoinColumn(name = "PlanSeviceid_FK")
    private PlanEventServices planEventService;

    private String serviceStatus;
    private LocalDateTime serviceDateTime;
    private double serviceRating;
    
    // optional 
    private Integer numberOfPeople; // Optional field for services that require it
    private String location; // Optional field for services that require location
    
    // constructor
    public UserUseService() {
    }
    public UserUseService(Long id, PlanEventServices planEventService, String serviceStatus, LocalDateTime serviceDateTime,
			double serviceRating, Integer numberOfPeople, String location
//			,PlanEvent planEvent
			) {
		super();
		this.id = id;
		this.planEventService = planEventService;
		this.serviceStatus = serviceStatus;
		this.serviceDateTime = serviceDateTime;
		this.serviceRating = serviceRating;
        this.numberOfPeople = numberOfPeople;
        this.location = location;
//        this.planEvent = planEvent;
	}
    public PlanEvent getPlanEvent() {
		return planEvent;
	}
	public void setPlanEvent(PlanEvent planEvent) {
		this.planEvent = planEvent;
	}
	// getter and setter
	public Long getId() {
		return id;
	}
	// updated the plan event services getter and setters 
	public PlanEventServices getPlanedEventService() {
		return planEventService;
	}
	public void setPlanEventService(PlanEventServices planedEventService) {
		planEventService = planedEventService;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public LocalDateTime getServiceDateTime() {
		return serviceDateTime;
	}
	public void setServiceDateTime(LocalDateTime serviceDateTime) {
		this.serviceDateTime = serviceDateTime;
	}
	public double getServiceRating() {
		return serviceRating;
	}
	public void setServiceRating(double serviceRating) {
		this.serviceRating = serviceRating;
	}
    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}
