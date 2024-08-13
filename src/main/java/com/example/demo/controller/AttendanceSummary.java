package com.example.demo.controller;

public class AttendanceSummary {

    private int presentDays;
    private int absentDays;

    public AttendanceSummary(int presentDays, int absentDays) {
        this.presentDays = presentDays;
        this.absentDays = absentDays;
    }

    // Getters and setters
    public int getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(int presentDays) {
        this.presentDays = presentDays;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays = absentDays;
    }
}
