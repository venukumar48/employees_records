package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/employees/{empCode}")
//    public EmployeeDetailsResponse getEmployeeDetails(@PathVariable String empCode) {
//        Employee employee = employeeService.getEmployeeByCode(empCode);
//        if (employee == null) {
//            return null; // or handle appropriately
//        }
//
//        LocalDate startDate = LocalDate.now().minusMonths(1);
//        // Example: last 30 days
//        System.out.println("startDate"+startDate);
//        LocalDate endDate = LocalDate.now();
//        System.out.println("endDate"+endDate);
//        AttendanceSummary   summary = employeeService.getAttendanceSummary(empCode, startDate, endDate);
//     //return "success";
//        return new EmployeeDetailsResponse(employee, summary);
//    }
    
    @GetMapping("/employees/empcodedate")
    public EmployeeDetailsResponse getEmployeeDetails( @RequestParam("fromdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromdate,@RequestParam("todate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate todate,@RequestParam("empCOde") String empCOde) {
        Employee employee = employeeService.getEmployeeByCode(empCOde);
        if (employee == null) {
            return null; // or handle appropriately
        }
        
  System.out.println("fromdate us"+fromdate+" todate is"+todate+"empcode is"+empCOde);
        LocalDate startDate = LocalDate.now().minusMonths(1);
        // Example: last 30 days
        System.out.println("startDate"+startDate);
        LocalDate endDate = LocalDate.now();
        System.out.println("endDate"+endDate);
        AttendanceSummary   summary = employeeService.getAttendanceSummary(empCOde, fromdate, todate);
     //return "success";
        return new EmployeeDetailsResponse(employee, summary);
    }

    
    
    
    @GetMapping("/employee/{EmpCode}")
    public String GetEmploeebyempCode(@PathVariable String EmpCode)
    {
    	System.out.println("EMpcode is"+EmpCode.toString());
    	employeeService.getEmployeeByCode(EmpCode);
    	
    	return "Success";
    }
    
     
        
    @GetMapping("/attendance/{EmpCode}")
    public String GetgetAttenndanceByEmpCode(@PathVariable String EmpCode)
    {
    	System.out.println("EMpcode is"+EmpCode.toString());
    	employeeService.getAttenndanceByEmpCode(EmpCode);
    	
    	return "Success";
    }
      
      
      
      
      
}
