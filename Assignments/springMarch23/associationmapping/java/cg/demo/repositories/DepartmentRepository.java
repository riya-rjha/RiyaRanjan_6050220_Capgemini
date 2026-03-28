package cg.demo.repositories;

import cg.demo.entity.Department;
import cg.demo.dto.DepartmentCountDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByName(String name);

    // Count employees per department
    @Query("SELECT new cg.demo.dto.DepartmentCountDTO(d.name, COUNT(e)) " +
           "FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
    List<DepartmentCountDTO> countEmployeesByDepartment();
}