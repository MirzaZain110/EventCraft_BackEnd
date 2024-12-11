//package com.eventcraft.Controller.PlanEvent;
//import java.time.LocalDateTime;
//
//public class helperdto {
//	
//	private int no_of_people;
//	private String location;
//	private String status;
//	private int budget;
//	private String disription;
//	private String event_name;
//	private LocalDateTime service_datetime;
//    private double serviceRating;
//	
//    
//	public helperdto() {
//		
//	}
//
//	public helperdto(int no_of_people, String status, int budget, String disription,
//			String event_name,double serviceRating,LocalDateTime service_datetime, String location) {
//		super();
//		this.no_of_people = no_of_people;
//		this.location = location;
//		this.status = status;
//		this.budget = budget;
//		this.disription = disription;
//		this.event_name = event_name;
//		this.serviceRating = serviceRating;
//		this.service_datetime = service_datetime; 
//	}
//
//	public LocalDateTime getService_datetime() {
//		return service_datetime;
//	}
//
//	public void setService_datetime(LocalDateTime service_datetime) {
//		this.service_datetime = service_datetime;
//	}
//
//	public double getServiceRating() {
//		return serviceRating;
//	}
//
//
//	public void setServiceRating(double serviceRating) {
//		this.serviceRating = serviceRating;
//	}
//	
//	public int getNo_of_people() {
//		return no_of_people;
//	}
//
//	public void setNo_of_people(int no_of_people) {
//		this.no_of_people = no_of_people;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	
//	public int getBudget() {
//		return budget;
//	}
//
//	public void setBudget(int budget) {
//		this.budget = budget;
//	}
//
//	public String getDisription() {
//		return disription;
//	}
//
//	public void setDisription(String disription) {
//		this.disription = disription;
//	}
//
//	public String getEvent_name() {
//		return event_name;
//	}
//
//	public void setEvent_name(String event_name) {
//		this.event_name = event_name;
//	}
//	
//}




package com.eventcraft.Controller.PlanEvent;

import java.time.LocalDateTime;
import java.util.List;

public class EventRequestDto {
    private String eventName;
    private String description;
    private double budget;
    private Long userId; // ID of the user creating the event
    private List<ServiceDetails> services;
    


	public EventRequestDto(String eventName, String description, double budget, Long userId,
			List<ServiceDetails> services) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.budget = budget;
		this.userId = userId;
		this.services = services;
	}

	// Inner class to hold service-specific details
    public static class ServiceDetails {
        private Long serviceId;
        public ServiceDetails(Long serviceId, int noOfPeople, String location, String status,
				LocalDateTime serviceDateTime, double serviceRating) {
			super();
			this.serviceId = serviceId;
			this.noOfPeople = noOfPeople;
			this.location = location;
			this.status = status;
			this.serviceDateTime = serviceDateTime;
			this.serviceRating = serviceRating;
		}

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
