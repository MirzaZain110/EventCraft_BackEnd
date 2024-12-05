package com.eventcraft.entities.Services;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.eventcraft.entities.Users.User;

@Entity
public class UserUseService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private UseService service;

    private String serviceStatus;
    private LocalDateTime serviceDateTime;
    private double serviceRating;
    
    // constructor
    public UserUseService() {
    }
    public UserUseService(Long id, User user, UseService service, String serviceStatus, LocalDateTime serviceDateTime,
			double serviceRating) {
		super();
		this.id = id;
		this.user = user;
		this.service = service;
		this.serviceStatus = serviceStatus;
		this.serviceDateTime = serviceDateTime;
		this.serviceRating = serviceRating;
	}
    // getter and setter
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UseService getService() {
		return service;
	}
	public void setService(UseService service) {
		this.service = service;
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

    
}
