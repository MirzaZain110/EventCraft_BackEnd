package com.eventcraft.DTO.ServiceProvider;

public class ServiceProviderDTO {

    private Long serviceProviderId;
    private String serviceProviderName;
    private String serviceProviderEmail;
    private String serviceProviderPhone;
    private String serviceProviderPassword;
    private String serviceProviderLocation;

    // Getters and Setters
    public Long getServiceProviderId() {
        return serviceProviderId;
    }

    public String getServiceProviderPassword() {
		return serviceProviderPassword;
	}

	public void setServiceProviderPassword(String serviceProviderPassword) {
		this.serviceProviderPassword = serviceProviderPassword;
	}

	public void setServiceProviderId(Long serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getServiceProviderEmail() {
        return serviceProviderEmail;
    }

    public void setServiceProviderEmail(String serviceProviderEmail) {
        this.serviceProviderEmail = serviceProviderEmail;
    }

    public String getServiceProviderPhone() {
        return serviceProviderPhone;
    }

    public void setServiceProviderPhone(String serviceProviderPhone) {
        this.serviceProviderPhone = serviceProviderPhone;
    }

    public String getServiceProviderLocation() {
        return serviceProviderLocation;
    }

    public void setServiceProviderLocation(String serviceProviderLocation) {
        this.serviceProviderLocation = serviceProviderLocation;
    }
}

