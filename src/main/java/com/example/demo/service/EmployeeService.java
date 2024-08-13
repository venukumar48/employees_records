package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.AttendanceSummary;
import com.example.demo.model.Attendance;
import com.example.demo.model.Employee;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Employee getEmployeeByCode(String empCode) {
    	System.out.println("emterwd in to service empcode is"+empCode);
    	  Employee employee = employeeRepository.findById(empCode).orElse(null);
          System.out.println("employee is "+employee);
  		return employee;
          
     
        
    }
    
    
    public Attendance getAttenndanceByEmpCode(String EmpCode)
    {
    	System.out.println("Service EmpCode is"+EmpCode);
    	
    	Attendance att= attendanceRepository.findByEmpCode(EmpCode);
    	System.out.println("Attendance is"+att.toString());
    	return att;
    }

    
  
   
    public AttendanceSummary getAttendanceSummary(String empCode, LocalDate startDate, LocalDate endDate) {
    	
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String dateString = startDate.format(formatter);
    String endDatedateString = endDate.format(formatter);
 
    List<Attendance>  attendances = attendanceRepository.findByEmpCodeAndDateBetween(empCode,dateString,endDatedateString);
      System.out.println("empcodeis"+empCode+"Startdate is"+startDate+"endDate si"+endDate);

      System.out.println("Attendancesssss is"+attendances.toString());

        int presentDays = (int) attendances.stream().filter(a -> "present".equalsIgnoreCase(a.getAttendanceStatus())).count();
        int absentDays = (int) attendances.stream().filter(a -> "absent".equalsIgnoreCase(a.getAttendanceStatus())).count();
          System.out.println("presentDays"+presentDays);
          System.out.println("absentDays"+absentDays);

        return new AttendanceSummary(presentDays, absentDays);
         // return attendances ;
    }
}
