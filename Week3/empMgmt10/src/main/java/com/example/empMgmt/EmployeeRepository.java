package com.example.empMgmt;
import com.example.empMgmt.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findActiveEmployeesByDepartmentId(@Param("departmentId") Long departmentId);

    @Modifying
    @Query("UPDATE Employee e SET e.active = :active WHERE e.id IN :ids")
    void updateEmployeesStatus(@Param("active") boolean active, @Param("ids") List<Long> ids);

	List<EmployeeProjectionImpl> findAllEmployeeProjections();
}
