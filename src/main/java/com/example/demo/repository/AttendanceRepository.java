package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
   
	@Query(value = "SELECT * FROM attendance A WHERE A.attendancedate BETWEEN TO_DATE(:startDate, 'YYYY-MM-DD') AND TO_DATE(:endDate, 'YYYY-MM-DD') AND A.EMP_CODE = :empCode", nativeQuery = true)
	List<Attendance>  findByEmpCodeAndDateBetween(@Param("empCode") String empCode,@Param("startDate") String startDate,@Param("endDate") String endDate);
	 
	 @Query(value = "SELECT * FROM attendance b WHERE b.emp_code = :empCode", nativeQuery = true)
	 Attendance findByEmpCode(@Param("empCode") String empCode);
	
	 
	 @Query(value = "SELECT * FROM attendance b WHERE b.attid = :attid", nativeQuery = true)
	  Attendance findByattid(@Param("attid") Long attid);
	
}
