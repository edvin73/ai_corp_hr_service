package com.edvin.hr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	
	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;
	
	@Column(name = "TEAM", nullable = false)
	private String team;
	

}
