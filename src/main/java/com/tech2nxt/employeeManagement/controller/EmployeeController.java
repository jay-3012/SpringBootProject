package com.tech2nxt.employeeManagement.controller;

import com.tech2nxt.employeeManagement.model.Employee;
import com.tech2nxt.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String homePage(Model model)
    {
        return findPaginated(1,model);
    }

    @GetMapping("/addNewEmployee")
    public String addEmployee(Model model)
    {
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable long id,Model model)
    {
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") long id)
    {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/list";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value="pageNo") int pageNo,
                                Model model)
    {
        int pageSize=5;
        Page<Employee> page=employeeService.findPaginated(pageNo,pageSize);
        List<Employee> listEmployees=page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("TotalItems",page.getTotalElements());
        model.addAttribute("listEmployees",listEmployees);
        return "list";
    }

}
