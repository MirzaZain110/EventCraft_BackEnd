package com.eventcraft.entities.Services;

import com.eventcraft.entities.ServiceProvider.ServiceProvider;
import jakarta.persistence.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UseService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String serviceName;
    private String serviceType;
    private double servicePrice;

    private String serviceCity;    // New attribute
    private String serviceArea;    // New attribute
    private int serviceCapacity;   // New attribute

    @ManyToOne
    @JoinColumn(name = "serviceProvider_id")
    private ServiceProvider serviceProvider;

    // For the Picture which user will upload for services 
    @OneToMany(mappedBy = "useService", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicePicture> pictures = new ArrayList<>();

    
    
    
    // Getters and Setters
    public List<ServicePicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<ServicePicture> pictures) {
        this.pictures = pictures;
    }
    
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public int getServiceCapacity() {
        return serviceCapacity;
    }

    public void setServiceCapacity(int serviceCapacity) {
        this.serviceCapacity = serviceCapacity;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    // Constructors

    public UseService(Long serviceId, String serviceName, String serviceType, double servicePrice, String serviceCity,
                      String serviceArea, int serviceCapacity, ServiceProvider serviceProvider, List<ServicePicture> pictures) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
        this.serviceCity = serviceCity;
        this.serviceArea = serviceArea;
        this.serviceCapacity = serviceCapacity;
        this.serviceProvider = serviceProvider;
        this.pictures = pictures; // updated for picture upload 
    }

    public UseService() {
    }
}
