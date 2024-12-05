package com.eventcraft.entities.Services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class ServicePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pictureId;

    @Column(nullable = false)
    private String pictureUrl; // Store the file path or URL of the picture

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnore
    private UseService useService;

    // Getters and Setters
    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public UseService getUseService() {
        return useService;
    }

    public void setUseService(UseService useService) {
        this.useService = useService;
    }

    // Constructor
    public ServicePicture(String pictureUrl, UseService useService) {
        this.pictureUrl = pictureUrl;
        this.useService = useService;
    }

    public ServicePicture() {
    }
}
