package com.eventcraft.Repository.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcraft.entities.Services.UserUseService;

@Repository
public interface UserUseServiceRepository extends JpaRepository<UserUseService, Long> {
	   List<UserUseService> findByPlanEventService_Service_ServiceId(Long serviceId);
	   List<UserUseService> findByPlanEvent_PlanEventId(Long planEventId);
	   List<UserUseService> findByPlanEventService_Id(Long planEventServiceId);
}


//public interface UserUseServiceRepository extends JpaRepository<UserUseService, Long> {
////	List<UserUseService> findByPlanedEventServiceId(Long planEventServiceId);
//	List<UserUseService> findByPlanedEvent_ServiceId(Long planEventServiceId);

//}

