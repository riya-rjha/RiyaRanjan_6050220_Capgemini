package cg.demo;

import java.util.List;

import cg.demo.dao.DepartmentEmployeeCount;
import cg.demo.dao.DepartmentEmployeeDetails;
import cg.demo.dao.EmployeeDAO;
import cg.demo.entity.AddressDemoEm;
import cg.demo.entity.Employee;
import cg.demo.entity.EmployeeDemoEm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        /*
         * // IndianPassport ip1 = new IndianPassport();
         * // Citizen c1 = new Citizen();
         * 
         * // c1.setAdharNo(123487);
         * // c1.setName("Aurelia");
         * // c1.setAddress("12/67 New Delhi");
         * 
         * // ip1.setPassportNo(87923);
         * // ip1.setPassportExpiracyDate(LocalDate.of(2029, 7, 16));
         * 
         * // ip1.setCitizen(c1);
         * // // BIDIRECTIONAL
         * // c1.setIp(ip1);
         * 
         * // em.persist(ip1);
         * 
         * // IndianPassport ip2 = new IndianPassport();
         * // Citizen c2 = new Citizen();
         * 
         * // c2.setAdharNo(25637);
         * // c2.setName("Zeus");
         * // c2.setAddress("7/23 Meerut");
         * 
         * // ip2.setPassportNo(187693);
         * // ip2.setPassportExpiracyDate(LocalDate.of(2031, 8, 5));
         * // ip2.setCitizen(c2);
         * // // BIDIRECTIONAL linking
         * // c2.setIp(ip2);
         * 
         * // IndianPassport ip3 = new IndianPassport();
         * // Citizen c3 = new Citizen();
         * 
         * // c3.setAdharNo(487);
         * // c3.setName("Yash");
         * // c3.setAddress("375/GF Vaishali");
         * 
         * // ip3.setPassportNo(9328);
         * // ip3.setPassportExpiracyDate(LocalDate.of(2021, 3, 12));
         * // ip3.setCitizen(c3);
         * // // BIDIRECTIONAL linking
         * // c3.setIp(ip3);
         * 
         * // // due to cascading, insertion is also done in citizen table
         * // em.persist(ip3);
         * 
         * // em.getTransaction().commit();
         * 
         * // System.out.println("Records inserted successfully");
         * 
         * // Make M employees -> 1 Department
         * 
         * // Employee e1 = new Employee("Suresh Raina", 98765);
         * // Employee e2 = new Employee("Joe Robert", 87542);
         * // Department d1 = new Department(21, "AIML", "Deepali Dev");
         * 
         * // e1.setDept(d1);
         * // e2.setDept(d1);
         * // em.persist(e1);
         * // em.persist(e2);
         * 
         * // Employee e3 = new Employee("Virat Kohli", 86754);
         * // Department d3 = new Department(9, "Computer Science", "Pankaj Sharma");
         * 
         * // e3.setDept(d3);
         * // em.persist(d3);
         * // em.persist(e3);
         * 
         * // Employee e3 = new Employee("Virat Kohli", 86754);
         * // Employee e4 = new Employee("Suresh Raina", 98765);
         * 
         * // Department d3 = new Department(17, "Mechanical", "Virmani");
         * // List<Employee> employees = new ArrayList<>();
         * // employees.add(e3);
         * // employees.add(e4);
         * 
         * // d3.setEmp(employees);
         * 
         * // em.persist(e3);
         * // em.persist(d3);
         * 
         * // Employee e4 = new Employee("MS Dhoni", 9873);
         * // Department d4 = new Department(19, "Cricket", "Gautam Gambhir");
         * 
         * // // EmployeeDAO.insert(e4);
         * 
         * // e4.setDept(d4);
         * // em.persist(e4);
         * // em.persist(d4);
         * 
         * 
         */

        List<Employee> allEmployees = EmployeeDAO.fetchAllEmployees("AIML", "Deepali Dev");
        System.out.println("Fetch all Employees whose dept HOD is: Deepali Dev & branch is AIML");
        System.out.println(allEmployees.toString());

        List<DepartmentEmployeeCount> allEmployeeCounts = EmployeeDAO.fetchCountEmployees();
        System.out.println("Fetch all employee counts for all departments: ");
        System.out.println(allEmployeeCounts.toString());

        List<Employee> allEmployeeForDept = EmployeeDAO.fetchRecordsDept("AIML");
        System.out.println("All employees for the dept: AIML");
        System.out.println(allEmployeeForDept.toString());

        List<DepartmentEmployeeDetails> deptDetails = EmployeeDAO.fetchDeptDetailsByEmployeeId(1);
        System.out.println("Details of employees for respective departments: ");
        System.out.println(deptDetails);

        List<Employee> allEmployeesCriteriaQuery = EmployeeDAO.fetchAllEmployees();
        System.out.println("All employees for all departments according to criteria query: ");
        System.out.println(allEmployeesCriteriaQuery.toString());

        List<Employee> allEmployeesSalaryCriteriaQuery = EmployeeDAO.fetchEmployeesBasedOnSalary(50000);
        System.out.println("All employees according to given salary criteria query: ");
        System.out.println(allEmployeesSalaryCriteriaQuery.toString());

        // Implementing Embedded & Embeddable

        EmployeeDemoEm demoEmployee = new EmployeeDemoEm(192, "Rohit Shetty",
                new AddressDemoEm(202192, "Navi Mumbai", "Maharashtra"));

        em.persist(demoEmployee);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}