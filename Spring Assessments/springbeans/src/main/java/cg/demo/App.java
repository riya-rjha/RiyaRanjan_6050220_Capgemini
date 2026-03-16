package cg.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.beans.Employee;

class App {

    public static void main(String[] args) {
        System.out.println("Starting the application");

        // implementation class for interface ApplicationContext is
        // ClassPathXmlApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConf.xml");
        
        System.out.println("Context is created");
        
//        If two times the same beans object is created, then only once the bean is instantiated
//        Singleton scope/pattern
//        constructor for that same name bean called only once
        
        Employee e2 = (Employee) ac.getBean("emp1"); // no such bean available
        Employee e = (Employee) ac.getBean("emp1");
        // Employee e = ac.getBean(Employee.class); // no need to typecast
        e.greet();
        e2.greet();
        System.out.println(e.toString());
        System.out.println(e2.toString());
        System.out.println("Ending the application");
    }

}