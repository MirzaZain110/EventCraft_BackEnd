package com.eventcraft.Services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eventcraft.Repository.UserRepository.UserRepository;
import com.eventcraft.entities.Users.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final String imageDirectory = "upload/images/usersImages";
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    // created for login
    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setUserEmail(updatedUser.getUserEmail());
        existingUser.setUserPassword(updatedUser.getUserPassword());
        existingUser.setUserPhone(updatedUser.getUserPhone());
        existingUser.setUserLocation(updatedUser.getUserLocation());
        existingUser.setUserDateOfBirth(updatedUser.getUserDateOfBirth());
        existingUser.setUserImage(updatedUser.getUserImage());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public String uploadUserImage(Long userId, MultipartFile file) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Ensure the directory exists
        Path uploadPath = Paths.get(imageDirectory);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Construct file name and save the file
            String fileName = "user_" + userId + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Update user's image path
            String fileUrl = filePath.toString();
//            user.setUserImage(fileUrl); 
            user.setUserImage(fileName); // updated for making url of get image work
            userRepository.save(user);

            return fileUrl;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image: " + e.getMessage());
        }
    }

    public String updateUserImage(Long userId, MultipartFile file) {
        User user = getUserById(userId);

        // Delete existing image
        if (user.getUserImage() != null) {
            Path oldImagePath = Paths.get(user.getUserImage());
            try {
                Files.deleteIfExists(oldImagePath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete old image: " + e.getMessage());
            }
        }

        // Upload new image
        return uploadUserImage(userId, file);
    }

    public void deleteUserImage(Long userId) {
        User user = getUserById(userId);

        if (user.getUserImage() != null) {
            Path imagePath = Paths.get(user.getUserImage());
            try {
                Files.deleteIfExists(imagePath);
                user.setUserImage(null);
                userRepository.save(user);
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image: " + e.getMessage());
            }
        }
    }
}
