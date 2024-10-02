package com.eventcraft.Repository.PlanEvent;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcraft.entities.PlanEvent.PlanEvent;

public interface PlanEventRepository extends JpaRepository<PlanEvent, Long> {
}
