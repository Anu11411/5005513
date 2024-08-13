package com.example.empMgmt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.example.empMgmt.DepartmentProjectionImpl(d.id, d.name) FROM Department d")
    List<DepartmentProjectionImpl> findAllDepartmentProjections();
}
