package cg.demos.springcore_assignments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import cg.demos.springcore_assignments.beans.Employee;
import cg.demos.springcore_assignments.beans.SBU;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("configurations.xml");
    	//Assignment 1.1, 1.2:
//    	Employee e1 = (Employee) ac.getBean("emp1");
//    	e1.displayDetails();
    	//Assignment 1.3:
    	SBU s1 = (SBU) ac.getBean("sbu1");
    	s1.displaySbuDetails();
//    	
    }
}
