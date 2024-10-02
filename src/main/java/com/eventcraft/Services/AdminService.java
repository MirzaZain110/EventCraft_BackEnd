package com.eventcraft.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.AdminRepository;
import com.eventcraft.entities.Admin;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        existingAdmin.setAdminName(updatedAdmin.getAdminName());
        existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
        existingAdmin.setAdminPassword(updatedAdmin.getAdminPassword());
        existingAdmin.setAdminPhone(updatedAdmin.getAdminPhone());

        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
