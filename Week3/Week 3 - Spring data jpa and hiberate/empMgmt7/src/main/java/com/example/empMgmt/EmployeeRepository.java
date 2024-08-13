package com.example.empMgmt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    
    // Find employees by their name
    List<Employee> findByName(String name);
    
    // Find employees by their email
    Employee findByEmail(String email);
    
    // Find employees by department id
    List<Employee> findByDepartmentId(Long departmentId);
}
