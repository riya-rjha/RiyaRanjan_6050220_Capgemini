package cg.demo.dto;

public class EmployeeMobileDTO {

    private int employeeId;
    private String employeeName;
    private String departmentName;
    private String managerName;

    public EmployeeMobileDTO(int employeeId, String employeeName, String departmentName, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    // getters
}