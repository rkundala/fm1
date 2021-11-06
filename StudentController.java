package com.student.controller;

import java.time.LocalDate;
import java.time.Year;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StudentController {

	@GetMapping("/student/{graduationYear}")

	public String findCurrentGrade(
			@PathVariable("graduationYear") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate graduationYear) {
		int years = graduationYear.getYear() - Year.now().getValue();
		String grade = "";
		if (years < 0) {
			grade = "99";
		} else if (years > 12) {
			grade = "0";
		} else {
			years = 12 - years;
			grade = "Grade: " + Integer.toString(years);
		}
		return grade;
	}

}