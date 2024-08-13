package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {

   @Id
    private Long attid;
    private String empCode;
    private LocalDate attendancedate;
    private String attendanceStatus;
	public Long getAttid() {
		return attid;
	}
	public void setAttid(Long attid) {
		this.attid = attid;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public LocalDate getAttendancedate() {
		return attendancedate;
	}
	public void setAttendancedate(LocalDate attendancedate) {
		this.attendancedate = attendancedate;
	}
	public String getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

    // Getters and Setters
    
	 @Override
		public String toString() {
			return "Attendance [attid=" + attid + ", empCode=" + empCode + ", attendancedate=" + attendancedate
					+ ", attendanceStatus=" + attendanceStatus + "]";
		}
		
    
    
   }
