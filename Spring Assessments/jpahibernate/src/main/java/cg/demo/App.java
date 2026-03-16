package cg.demo;

import cg.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // INSERT
        Employee e = new Employee();
        e.setId(19);
        e.setEname("Neha");
        e.setDept("HR");
        e.setSalary(45000);
        e.setPhoneNO(99999);
        em.persist(e);
        System.out.println("Employee inserted");

        /*
         * 
         * // SELECT
         * Employee emp = em.find(Employee.class, 101);
         * 
         * if(emp != null){
         * System.out.println("Employee found: " + emp.getEname());
         * }
         * 
         * // UPDATE
         * if(emp != null){
         * emp.setSalary(75000);
         * em.merge(emp);
         * System.out.println("Employee updated");
         * }
         */
        // DELETE
        // do this without find method
        // Employee delEmp = em.find(Employee.class, 18);

        // if(delEmp != null){
        // em.remove(delEmp);
        // System.out.println("Employee deleted");
        // }

        // Employee delEmp1 = new Employee();

        // delEmp1.setId(18);
        // delEmp1.setEname("dummy");
        // delEmp1.setDept("dummy");
        // delEmp1.setSalary(0);
        // delEmp1.setPhoneNO(0);

        // em.remove(delEmp1);
        // System.out.println("Employee deleted");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}