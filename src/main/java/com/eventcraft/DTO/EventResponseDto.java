package com.eventcraft.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class EventResponseDto {
    private String eventName;
    private String description;
    private double budget;
    private Long userId;
    private List<ServiceDetails> services;

    // Inner class for service-specific details
    public static class ServiceDetails {
        private Long serviceId;
        private String serviceName; // Optional, for service display
        private int noOfPeople;
        private String location;
        private String status;
        private LocalDateTime serviceDateTime;
        private double serviceRating;

        // Getters and setters
        public Long getServiceId() {
            return serviceId;
        }

        public void setServiceId(Long serviceId) {
            this.serviceId = serviceId;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public int getNoOfPeople() {
            return noOfPeople;
        }

        public void setNoOfPeople(int noOfPeople) {
            this.noOfPeople = noOfPeople;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    // Getters and setters for outer class
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ServiceDetails> getServices() {
        return services;
    }

    public void setServices(List<ServiceDetails> services) {
        this.services = services;
    }
}
