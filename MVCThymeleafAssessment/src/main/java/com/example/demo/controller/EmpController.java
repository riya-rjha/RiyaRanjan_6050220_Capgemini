package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @GetMapping("/viewall")
    public ModelAndView viewAllEmployees() {

        List<Employee> empList = empRepository.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("emps", empList);
        mv.addObject("emp", new Employee());
        mv.setViewName("view");

        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable Integer id) {

        Employee emp = empRepository.findById(id).orElse(null);

        ModelAndView mv = new ModelAndView();
        mv.addObject("emp", emp);
        mv.setViewName("edit");

        return mv;
    }

    @PostMapping("/update")
    public ModelAndView updateEmployee(@Valid @ModelAttribute("emp") Employee emp,
                                       BindingResult result) {

        ModelAndView mv = new ModelAndView();

        if (result.hasFieldErrors("empDoj")) {

            for (FieldError error : result.getFieldErrors("empDoj")) {

                result.rejectValue(
                        "empDoj",
                        "invalid.date",
                        "Invalid date format. Use yyyy-MM-dd (e.g. 2025-04-10)"
                );
            }
        }

        if (result.hasErrors()) {
            mv.setViewName("edit");
            return mv;
        }

        empRepository.save(emp);

        mv.addObject("emps", empRepository.findAll());
        mv.addObject("msg", "Employee Edited");
        mv.setViewName("view");

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable Integer id) {

        empRepository.deleteById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("emps", empRepository.findAll());
        mv.addObject("msg", "Employee Deleted");
        mv.setViewName("view");

        return mv;
    }


    @GetMapping("/allEmployees")
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }
    
    @DeleteMapping("/deleteEmp/{id}")
    @ResponseBody
    public String deleteEmp(@PathVariable Integer id) {
        empRepository.deleteById(id);
        return "Employee Deleted";
    }

    @PutMapping("/updateEmp/{id}")
    @ResponseBody
    public String updateEmp(@PathVariable Integer id,
                           @RequestBody Employee newEmp) {

        Employee emp = empRepository.findById(id).orElse(null);

        if (emp != null) {
            emp.setEmpName(newEmp.getEmpName());
            emp.setEmpSal(newEmp.getEmpSal());
            emp.setEmpDoj(newEmp.getEmpDoj());
            emp.setDeptName(newEmp.getDeptName());

            empRepository.save(emp);
            return "Employee Updated";
        } else {
            return "Employee Not Found";
        }
    }
}