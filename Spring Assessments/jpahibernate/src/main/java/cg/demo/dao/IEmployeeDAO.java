package cg.demo.dao;

import java.sql.SQLException;
import java.util.List;

import cg.demo.entity.Employee;

public interface IEmployeeDAO {

    void insertEmployee(Employee emp);

    Employee viewEmployeesWithId(int id) throws SQLException;

    Employee updateEmployee(int id, float salary);

    Employee deleteEmployee(int id) throws SQLException;

    List<Employee> fetchEmployees();

    List<Employee> getEmployeesBySalary(double sal);

    Employee getEmployeeByPhone(String phone);
}