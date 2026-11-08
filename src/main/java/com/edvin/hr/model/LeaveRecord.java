package com.edvin.hr.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "LEAVE_RECORD")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "LEAVE_DATE", nullable = false)
	private LocalDate leaveDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private LeaveStatus status;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CREATED_AT", nullable = false)
	private LocalDate createdAt;

}
