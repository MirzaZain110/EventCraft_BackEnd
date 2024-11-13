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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
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

        String directory = "uploads/images/";
        new File(directory).mkdirs(); // Ensure directory exists

        String fileName = "user_" + userId + "_" + file.getOriginalFilename();
        Path imagePath = Paths.get(directory + fileName);

        try {
            Files.copy(file.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }

        String imageUrl = "http://localhost:8080/" + directory + fileName;
        user.setUserImage(imageUrl);
        userRepository.save(user);

        return imageUrl;
    }
}
