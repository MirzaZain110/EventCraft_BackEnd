package com.eventcraft.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eventcraft.Services.User.UserService;
import com.eventcraft.entities.Users.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        try {
            // Validate the request payload
            if (loginRequest.getUserEmail() == null || loginRequest.getUserPassword() == null) {
                return ResponseEntity.badRequest().body("Email and password must be provided.");
            }

            // Fetch the user by email
            User existingUser = userService.getUserByEmail(loginRequest.getUserEmail());
            if (existingUser == null) {
                return ResponseEntity.status(404).body("User not found.");
            }

            // Verify the password
            if (!existingUser.getUserPassword().equals(loginRequest.getUserPassword())) {
                return ResponseEntity.status(401).body("Invalid credentials.");
            }

            // Successful login: Return the user object (excluding sensitive fields, if needed)
//            existingUser.setUserPassword(null); // Hide the password for security
            return ResponseEntity.ok(existingUser);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
    
    // images work are here 
    
    @PostMapping("/{id}/uploadImage")
    public ResponseEntity<String> uploadUserImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
        String imageUrl = userService.uploadUserImage(id, file);
        return ResponseEntity.ok(imageUrl);
    }

    @PutMapping("/{id}/updateImage")
    public ResponseEntity<String> updateUserImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
        String updatedImageUrl = userService.updateUserImage(id, file);
        return ResponseEntity.ok(updatedImageUrl);
    }

    @DeleteMapping("/{id}/deleteImage")
    public ResponseEntity<String> deleteUserImage(@PathVariable Long id) {
        userService.deleteUserImage(id);
        return ResponseEntity.ok("Image deleted successfully.");
    }
    // get images 
    
    @GetMapping("/images/{filename}") // updated the image name instead of url from service
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        Path imagePath = Paths.get("upload/images/usersImages").resolve(filename);

        try {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust if needed
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    } // how call EX: http://localhost:8080/api/users/images/user_1_Profile1.jpg
}
