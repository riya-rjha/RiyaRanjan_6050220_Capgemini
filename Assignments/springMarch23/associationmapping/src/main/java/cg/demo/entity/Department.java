package cg.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Department name cannot be empty")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Manager name cannot be empty")
    private String managerName;

    // One department → Many employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;

    // getters and setters
}