package cg.demo.dto;

public class EmployeeDeptDTO {

    private String employeeName;
    private double salary;
    private String departmentName;
    private String managerName;

    public EmployeeDeptDTO(String employeeName, double salary, String departmentName, String managerName) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    // getters
}