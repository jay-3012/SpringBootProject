package com.tech2nxt.employeeManagement.service;

import com.tech2nxt.employeeManagement.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService
{
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo,int pageSize);

}
