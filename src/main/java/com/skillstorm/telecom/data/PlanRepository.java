package com.skillstorm.telecom.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.telecom.beans.Device;
import com.skillstorm.telecom.beans.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{

	@Query(value = "select * from plans, devices where devices.plan_id = ? and plans.plan_id = ?", nativeQuery = true)
	public List<Plan> findTotal(int deviceId, int planId);
	
	@Modifying
    @Transactional
	@Query(value = "delete from plans where plans.plan_id = ?", nativeQuery = true)	
	public void delete(@Param("id") int id);
	
}
