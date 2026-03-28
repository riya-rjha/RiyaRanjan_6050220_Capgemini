package cg.demo.repositories;

import cg.demo.entity.Employee;
import cg.demo.dto.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Fetch all employees with department details (JOIN FETCH)
    @Query("SELECT new cg.demo.dto.EmployeeDeptDTO(e.name, e.salary, d.name, d.managerName) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeDeptDTO> getAllEmployeesWithDepartment();

    // Employees by department name
    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    // Find by mobile number
    @Query("SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mobile")
    Optional<Employee> findByMobile(@Param("mobile") String mobile);
}