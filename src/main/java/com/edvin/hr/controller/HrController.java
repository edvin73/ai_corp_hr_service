package com.edvin.hr.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edvin.hr.model.LeaveRecord;
import com.edvin.hr.service.HrService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hr")
public class HrController {
	
	private final HrService hrService;
	
	
	@PostMapping("/leave")
	public LeaveRecord applyLeave(@RequestParam String username, 
									@RequestParam
									@DateTimeFormat(pattern = "yyyy-MM-dd")
									LocalDate leaveDate) {
		
		return hrService.applyLeave(username, leaveDate);
	}
	
	@GetMapping("/leave/{username}")
	public boolean isOnLeave(@PathVariable String username, 
								@RequestParam
								@DateTimeFormat(pattern = "yyyy-MM-dd")
								LocalDate date) {
		
		return hrService.isOnLeave(username, date);
	}
	
	@GetMapping("/replacement/{username}")
	public String findReplacement(@PathVariable String username, 
									@RequestParam
									@DateTimeFormat(pattern = "yyyy-MM-dd")
									LocalDate date) {
		
		return hrService.findReplacement(username, date);
	}

}
