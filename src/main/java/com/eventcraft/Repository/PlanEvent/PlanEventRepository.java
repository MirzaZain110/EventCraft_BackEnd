package com.eventcraft.Repository.PlanEvent;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.eventcraft.entities.PlanEvent.PlanEvent;
//
//public interface PlanEventRepository extends JpaRepository<PlanEvent, Long> {

//@Query("SELECT pe FROM plan_event pe " +
//     "JOIN FETCH pe.users u " +
//     "LEFT JOIN FETCH pe.plan_event_services pes " +
//     "LEFT JOIN FETCH pes.service us " +
//     "WHERE u.userId = :userId")
//List<PlanEvent> findByUserId(Long userId);
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.Query;
import com.eventcraft.entities.PlanEvent.PlanEvent;
import com.eventcraft.entities.Users.User;

import java.util.List;


@Repository
public interface PlanEventRepository extends JpaRepository<PlanEvent, Long> {

	List<PlanEvent> findByUser_UserId(Long userId);



	
	
}
