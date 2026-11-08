package com.edvin.hr.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edvin.hr.model.Employee;
import com.edvin.hr.model.LeaveRecord;

@Repository
public interface LeaveRecordRepository extends JpaRepository<LeaveRecord, Long> {
	
	Optional<LeaveRecord> findByUsernameAndLeaveDate(String username, LocalDate leaveDate);

}
