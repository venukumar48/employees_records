package com.example.demo.model;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

   
	@Id
    private String empCode;
    private String ename;
    private String phone;
    private String email;
    @Lob
    @JsonIgnore
    private Blob profilePic;

    // Getters and Setters
    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return ename;
    }

    public void setName(String ename) {
        this.ename = ename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Blob profilePic) {
        this.profilePic = profilePic;
    }
    @Override
   	public String toString() {
   		return "Employee [empCode=" + empCode + ", ename=" + ename + ", phone=" + phone + ", email=" + email
   				+ ", profilePic=" + profilePic + "]";
   	}

}
