package com.example.demo.controller;

import com.example.demo.model.Employee;

public class EmployeeDetailsResponse {

    private Employee empDetail;
    private AttendanceSummary attendance;

    public EmployeeDetailsResponse(Employee empDetail, AttendanceSummary attendance) {
        this.empDetail = empDetail;
        this.attendance = attendance;
    }

    // Getters and setters
    public Employee getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Employee empDetail) {
        this.empDetail = empDetail;
    }

    public AttendanceSummary getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceSummary attendance) {
        this.attendance = attendance;
    }
}
