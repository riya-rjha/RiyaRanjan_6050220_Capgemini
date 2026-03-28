package cg.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Employee name cannot be empty")
    private String name;

    @Positive(message = "Salary must be positive")
    private double salary;

    @ElementCollection
    @CollectionTable(name = "employee_mobiles", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "mobile_number")
    @NotEmpty(message = "At least one mobile number required")
    private Set<@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number") String> mobileNumbers;

    // Many employees → One department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}