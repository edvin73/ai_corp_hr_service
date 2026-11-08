package com.edvin.hr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edvin.hr.model.Employee;
import com.edvin.hr.model.LeaveRecord;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByUsername(String username);
	
	List<Employee> findByTeam(String team);

}
