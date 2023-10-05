package com.example.savis_intern_project.repository;

import com.example.savis_intern_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query("SELECT e from Employee e WHERE e.fullName=?1 and e.phoneNumber=?2")
    List<Employee> timKiem(String name,String phone);

    @Query("SELECT e from Employee e WHERE e.fullName=?1 or e.phoneNumber=?2")
    List<Employee> timKiem2(String name,String phone);
}
