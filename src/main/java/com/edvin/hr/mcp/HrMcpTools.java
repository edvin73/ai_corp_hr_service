package com.edvin.hr.mcp;

import java.time.LocalDate;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import com.edvin.hr.service.HrService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HrMcpTools {

	private final HrService hrService;

	@McpTool(name = "applyLeave", description = "Apply for leave on a specific date ISO-8601 format (yyyy-MM-dd)")
	public String applyLeave(@McpToolParam(description = "The user name") String username,
			@McpToolParam(description = "The date to apply leave on") String leaveDate) {

		hrService.applyLeave(username, LocalDate.parse(leaveDate));

		return "Leave applied for " + username + " on " + leaveDate;
	}

	@McpTool(name = "findReplacementForLeave", description = "Find a replacement for a leave on a specific date in ISO-8601 format (yyyy-MM-dd)")
	public String findReplacementForLeave(@McpToolParam(description = "The user name") String username,
			@McpToolParam(description = "The date to apply leave on") String leaveDate) {

		String replacement = hrService.findReplacement(username, LocalDate.parse(leaveDate));

		return "Replacement found for " + username + " on " + leaveDate + " is " + replacement;
	}

}
