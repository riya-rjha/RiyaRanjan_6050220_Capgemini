package cg.demo.services;

import cg.demo.entity.*;
import cg.demo.dto.*;
import cg.demo.repositories.*;
import cg.demo.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    // Insert Employee
    public Employee insertEmployee(Employee emp, String deptName) {

        Department dept = deptRepo.findByName(deptName)
                .orElseThrow(() -> new DepartmentNameNotFoundException("Department not found"));

        emp.setDepartment(dept);
        return empRepo.save(emp);
    }

    // Fetch all employees with department details
    public List<EmployeeDeptDTO> getAllEmployees() {
        return empRepo.getAllEmployeesWithDepartment();
    }

    // Count employees per department
    public List<DepartmentCountDTO> getEmployeeCountByDept() {
        return deptRepo.countEmployeesByDepartment();
    }

    // Employees under given department
    public List<Employee> getEmployeesByDept(String deptName) {
        List<Employee> list = empRepo.findByDepartmentName(deptName);

        if (list.isEmpty()) {
            throw new DepartmentNameNotFoundException("No employees found for department");
        }

        return list;
    }

    // Fetch employee + department by mobile
    public EmployeeMobileDTO getByMobile(String mobile) {

        Employee emp = empRepo.findByMobile(mobile)
                .orElseThrow(() -> new MobileNumberDoesNotExistsForEmployeeException("Mobile not found"));

        Department d = emp.getDepartment();

        return new EmployeeMobileDTO(emp.getId(), emp.getName(), d.getName(), d.getManagerName());
    }
}