package com.eventcraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventcraft.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}