package com.eventcraft.Repository.PlanEvent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcraft.entities.PlanEvent.PlanEventServices;

//public interface PlanEventServicesRepository extends JpaRepository<PlanEventServices, Long> {
//}


public interface PlanEventServicesRepository extends JpaRepository<PlanEventServices, Long> {
	List<PlanEventServices> findByPlanEvent_PlanEventId(Long planEventId);
}
