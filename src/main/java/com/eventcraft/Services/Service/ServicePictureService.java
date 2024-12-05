package com.eventcraft.Services.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eventcraft.Repository.Service.ServicePictureRepository;
import com.eventcraft.Repository.Service.ServiceRepository;
import com.eventcraft.entities.Services.ServicePicture;
import com.eventcraft.entities.Services.UseService;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class ServicePictureService {

    private final String imageDirectory = "upload/images/service_images"; // Directory for storing images

    @Autowired
    private ServicePictureRepository pictureRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    // Upload a new image for a service
//    public String uploadServiceImage(Long serviceId, MultipartFile file) {
//        UseService service = serviceRepository.findById(serviceId)
//                .orElseThrow(() -> new RuntimeException("Service not found"));
//
//        Path uploadPath = Paths.get(imageDirectory);
//        try {
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            // Construct file name and save the file
//            String fileName = "service_" + serviceId + "_" + file.getOriginalFilename();
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Save picture record to the database
//            ServicePicture servicePicture = new ServicePicture(fileName, service);
//            pictureRepository.save(servicePicture);
//
//            return fileName;
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload image: " + e.getMessage());
//        }
//    }
    public ServicePicture uploadServiceImage(Long serviceId, MultipartFile file) {
        UseService service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Path uploadPath = Paths.get(imageDirectory);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = "service_" + serviceId + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            ServicePicture servicePicture = new ServicePicture(fileName, service);
            return pictureRepository.save(servicePicture);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image: " + e.getMessage());
        }
    }

    // Update an existing image
//    public String updateServiceImage(Long pictureId, MultipartFile file) {
//        ServicePicture existingPicture = pictureRepository.findById(pictureId)
//                .orElseThrow(() -> new RuntimeException("Picture not found"));
//
//        Path oldImagePath = Paths.get(imageDirectory, existingPicture.getPictureUrl());
//        try {
//            // Delete old image if it exists
//            Files.deleteIfExists(oldImagePath);
//
//            // Upload new image
//            String fileName = "service_" + existingPicture.getUseService().getServiceId() + "_" + file.getOriginalFilename();
//            Path newFilePath = Paths.get(imageDirectory).resolve(fileName);
//            Files.copy(file.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Update the database record
//            existingPicture.setPictureUrl(fileName);
//            pictureRepository.save(existingPicture);
//
//            return fileName;
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to update image: " + e.getMessage());
//        }
//    }

    
    public String updateServiceImage(Long serviceId, Long pictureId, MultipartFile file) {
        ServicePicture existingPicture = pictureRepository.findById(pictureId)
                .orElseThrow(() -> new RuntimeException("Picture not found"));

        if (!existingPicture.getUseService().getServiceId().equals(serviceId)) {
            throw new RuntimeException("Picture does not belong to the specified service");
        }

        Path oldImagePath = Paths.get(imageDirectory, existingPicture.getPictureUrl());
        try {
            Files.deleteIfExists(oldImagePath);

            String fileName = "service_" + serviceId + "_" + file.getOriginalFilename();
            Path newFilePath = Paths.get(imageDirectory).resolve(fileName);
            Files.copy(file.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);

            existingPicture.setPictureUrl(fileName);
            pictureRepository.save(existingPicture);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to update image: " + e.getMessage());
        }
    }

    // Delete a service image
    public void deleteServiceImage(Long pictureId) {
        ServicePicture picture = pictureRepository.findById(pictureId)
                .orElseThrow(() -> new RuntimeException("Picture not found"));

        Path imagePath = Paths.get(imageDirectory, picture.getPictureUrl());
        try {
            Files.deleteIfExists(imagePath);
            pictureRepository.deleteById(pictureId);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image: " + e.getMessage());
        }
    }

    // Get all images for a service
    public List<ServicePicture> getServiceImages(Long serviceId) {
        return pictureRepository.findByUseService_ServiceId(serviceId);
    }
}
