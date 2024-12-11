package com.eventcraft.entities.Users;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users") // Optional: Explicit table name, can be omitted if not needed.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userPhone;

    @Column(nullable = true)
    private String userLocation;

    @Column(nullable = true)
    private LocalDate userDateOfBirth;

    @Column(nullable = true) // Optional
    private String userImage; // New field for the user image URL

    // Getters and Setters

    public User() {
        // Default constructor
    }
    public User(Long userId, String userName, String userEmail, String userPassword, String userPhone,
			String userLocation, LocalDate userDateOfBirth, String userImage) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userLocation = userLocation;
		this.userDateOfBirth = userDateOfBirth;
		this.userImage = userImage;
	}
	public User(Long userId) {
        this.userId = userId;
    }

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(LocalDate userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
