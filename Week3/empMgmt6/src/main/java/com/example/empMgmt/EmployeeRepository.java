package com.example.empMgmt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    
    List<Employee> findByName(String name);
    
    Employee findByEmail(String email);
    
    List<Employee> findByDepartmentId(Long departmentId);
}
