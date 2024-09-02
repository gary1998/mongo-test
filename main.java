package com.edge.college;

import java.time.LocalDate;
import java.util.HashMap;

import com.edge.college.student.*;

public class CollegeApplication {

	public static void main(String[] args) {
		try {
			Student.registerStudent(0, "Gaurav", "29-01-2000");
			Student.registerStudent(1, "Naresh", "01-03-2020");
			// Student.registerStudent(0, "Exception", "29-01-2000");
			Student.registerStudent(4, "Abhishek", "29-01-1993");

			// Attendance.markPresent(5, LocalDate.of(2024, 8, 10));
			Attendance.markPresent(0, LocalDate.of(2024, 8, 10));
			Attendance.markPresent(0, LocalDate.of(2024, 8, 11));
			Attendance.markPresent(0, LocalDate.of(2024, 7, 10));
			Attendance.markPresent(0, LocalDate.of(2024, 7, 10));
			
			Attendance.markPresent(1, LocalDate.of(2024, 8, 10));
			Attendance.markPresent(1, LocalDate.of(2024, 7, 10));
			Attendance.markPresent(1, LocalDate.of(2024, 8, 11));
			Attendance.markPresent(1, LocalDate.of(2024, 7, 10));
			
			Attendance.markPresent(4, LocalDate.of(2024, 8, 10));
			Attendance.markPresent(4, LocalDate.of(2024, 7, 10));

			HashMap<String, HashMap<String, Integer>> report = Attendance.getReport("2024");
			report.forEach((k, v) -> System.out.println(k + " - " + v +"\n"));
		} catch (Exception e) {
			System.out.println("exception occurred: " + e.getMessage());
		}

	}

}
