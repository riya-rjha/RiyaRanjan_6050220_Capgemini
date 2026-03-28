package cg.demo.dto;

public class DepartmentCountDTO {

    private String departmentName;
    private long employeeCount;

    public DepartmentCountDTO(String departmentName, long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    // getters
}