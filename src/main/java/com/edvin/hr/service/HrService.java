package com.edvin.hr.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edvin.hr.model.Employee;
import com.edvin.hr.model.LeaveRecord;
import com.edvin.hr.model.LeaveStatus;
import com.edvin.hr.repository.EmployeeRepository;
import com.edvin.hr.repository.LeaveRecordRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HrService {
	
	private final EmployeeRepository employeeRepository;
	private final LeaveRecordRepository leaveRecordRepository;
	
	
	public LeaveRecord applyLeave(String username, LocalDate leaveDate) {
		 
		return leaveRecordRepository.findByUsernameAndLeaveDate(username, leaveDate)
				.orElseGet(() -> {
					LeaveRecord leaveRecord = LeaveRecord.builder()
							.username(username)
							.leaveDate(leaveDate)
							.status(LeaveStatus.APPROVED)
							.createdAt(LocalDate.now())
							.build();
					return leaveRecordRepository.save(leaveRecord);
				});
	}
	
	public boolean isOnLeave(String username, LocalDate date) {
		
		return leaveRecordRepository.findByUsernameAndLeaveDate(username, date)
				.map(leaveRecord -> leaveRecord.getStatus() == LeaveStatus.APPROVED)
				.orElse(false);
	}
	
	public String findReplacement(String username, LocalDate date) {
		
		 Employee current = employeeRepository.findByUsername(username)
				 .orElseThrow(() -> new RuntimeException("Employee not found"));
		 
		 List<Employee> teamMembers = employeeRepository.findByTeam(current.getTeam());
		 
		 
		 for (Employee member : teamMembers) {
			 if (!member.getUsername().equals(username) && !isOnLeave(member.getUsername(), date)) {
				 return member.getUsername();
			 }
		 }
		 
		 throw new RuntimeException("No available replacement found for " + username + " on " + date);
		 
	}
}
