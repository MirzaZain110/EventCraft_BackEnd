package com.eventcraft.entities.ServiceProvider;

import jakarta.persistence.*;

@Entity
public class ServiceProvider {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceProviderId;

    @Column(nullable = false)
	private String serviceProviderEmail;
    
    @Column(nullable = false)
    private String serviceProviderPassword;

    @Column(nullable = false)
    private String serviceProviderPhone;

    private String serviceProviderLocation;
    
    private String serviceProviderName;
    
    public Long getServiceProviderId() {
		return serviceProviderId;
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
	public String getServiceProviderPassword() {
		return serviceProviderPassword;
	}
	public void setServiceProviderPassword(String serviceProviderPassword) {
		this.serviceProviderPassword = serviceProviderPassword;
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

