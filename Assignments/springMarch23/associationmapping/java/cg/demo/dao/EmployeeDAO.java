package cg.demo.dao;

import java.util.*;
import cg.demo.entity.Employee;
import cg.demo.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

public class EmployeeDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    private static EntityManager em = emf.createEntityManager();

    // insert employee
    public static void insert(Employee emp) {
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    // fetch all employees by dept name & hod name
    public static List<Employee> fetchAllEmployees(String deptName, String deptHOD) {
        /*
         * JPQL:
         * String jpString = "select e from Department d JOIN d.emp e
         * WHERE d.dname = :deptName AND d.hod = :deptHOD";
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Department> deptRoot = cq.from(Department.class);
        Join<Department, Employee> empJoin = deptRoot.join("emp");
        Predicate deptPredicate = cb.equal(deptRoot.get("dname"), deptName);
        Predicate hodPredicate = cb.equal(deptRoot.get("hod"), deptHOD);
        cq.select(empJoin)
                .where(cb.and(deptPredicate, hodPredicate));
        TypedQuery<Employee> query = em.createQuery(cq);
        return query.getResultList();
    }

    // fetch employees count working under each department
    public static List<DepartmentEmployeeCount> fetchCountEmployees() {

        /*
         * JPQL:
         * select new DepartmentEmployeeCount(d.dname, COUNT(e))
         * FROM Department d JOIN d.emp e GROUP BY d.dname
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DepartmentEmployeeCount> cq = cb.createQuery(DepartmentEmployeeCount.class);

        Root<Department> deptRoot = cq.from(Department.class);
        Join<Department, Employee> empJoin = deptRoot.join("emp");
        cq.select(cb.construct(
                DepartmentEmployeeCount.class,
                deptRoot.get("dname"),
                cb.count(empJoin)));
        cq.groupBy(deptRoot.get("dname"));

        TypedQuery<DepartmentEmployeeCount> query = em.createQuery(cq);
        return query.getResultList();
    }

    // fetch records of employees working under given dept
    public static List<Employee> fetchRecordsDept(String dept) {
        /*
         * JPQL:
         * select e from Department d JOIN d.emp e WHERE d.dname = :dept
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Department> deptRoot = cq.from(Department.class);
        Join<Department, Employee> empJoin = deptRoot.join("emp");
        Predicate deptPredicate = cb.equal(deptRoot.get("dname"), dept);
        cq.select(empJoin).where(deptPredicate);

        TypedQuery<Employee> query = em.createQuery(cq);
        return query.getResultList();
    }

    // fetch dept details with eid, name from eid *(mob number)
    public static List<DepartmentEmployeeDetails> fetchDeptDetailsByEmployeeId(int empId) {
        /*
         * JPQL:
         * SELECT new DepartmentEmployeeDetails(d.dname, d.hod, e.emid, e.emname)
         * FROM Department d JOIN d.emp e WHERE e.emid = :id
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DepartmentEmployeeDetails> cq = cb.createQuery(DepartmentEmployeeDetails.class);
        Root<Department> deptRoot = cq.from(Department.class);
        Join<Department, Employee> empJoin = deptRoot.join("emp");

        Predicate idPredicate = cb.equal(empJoin.get("emid"), empId);
        cq.select(cb.construct(
                DepartmentEmployeeDetails.class,
                deptRoot.get("dname"),
                deptRoot.get("hod"),
                empJoin.get("emid"),
                empJoin.get("emname"))).where(idPredicate);
        TypedQuery<DepartmentEmployeeDetails> query = em.createQuery(cq);
        return query.getResultList();
    }

    // fetch all employees
    public static List<Employee> fetchAllEmployees() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(root);

        TypedQuery<Employee> query = em.createQuery(cq);

        return query.getResultList();
    }

    // fetch all employees based on salary
    public static List<Employee> fetchEmployeesBasedOnSalary(int salary) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate salaryPredicate = cb.gt(root.get("emsalary"), salary);
        cq.select(root).where(salaryPredicate);

        TypedQuery<Employee> query = em.createQuery(cq);

        return query.getResultList();
    }

}