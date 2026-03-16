package cg.demo.dao;

import java.sql.SQLException;
import java.util.List;

import cg.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeDAO implements IEmployeeDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void insertEmployee(Employee emp) {
        em.getTransaction().begin();
        em.persist(emp); // insertion
        em.getTransaction().commit();
    }

    @Override
    public Employee viewEmployeesWithId(int id) throws SQLException {
        Employee result = null;
        em.getTransaction().begin();
        result = em.find(Employee.class, id);
        em.getTransaction().commit();
        return result;
    }

    // update employee's salary
    @Override
    public Employee updateEmployee(int id, float salary) {
        Employee result;
        em.getTransaction().begin();
        Employee emp = em.find(Employee.class, id);
        emp.setSalary(salary);
        System.out.println(em.merge(emp));
        result = em.find(Employee.class, id);
        em.getTransaction().commit();
        return result;
    }

    @Override
    public Employee deleteEmployee(int id) throws SQLException {
        // Employee toBeRemoved = em.find(Employee.class, id);
        // if (toBeRemoved != null) {
        // em.remove(toBeRemoved);
        // }

        // merge -> find()
        // new, managed, detached, removed

        // New Employee in detached state, cannot be removed
        // Employee toBeRemoved = new Employee();
        // toBeRemoved.setId(id);
        // em.remove(toBeRemoved);

        em.getTransaction().begin();
        Employee toBeRemoved = em.find(Employee.class, id);
        if (toBeRemoved != null) {
            em.remove(toBeRemoved);
        }
        em.getTransaction().commit();
        return toBeRemoved;
    }

    // JPQL
    // fetchAllRecords
    // create through EntityManager object

    @Override
    public List<Employee> fetchEmployees() {
        String jpql = "SELECT e FROM Employee e";
        List<Employee> list = em.createQuery(jpql, Employee.class)
                .getResultList();
        return list;
    }

    @Override
    public List<Employee> getEmployeesBySalary(double sal) {
        String jpql = "SELECT e FROM Employee e WHERE e.salary = :sal";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("sal", sal);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeByPhone(String phone) {
        String jpql = "SELECT e FROM Employee e WHERE e.phone = :phone";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("phone", phone);
        return query.getSingleResult();
    }

}