package com.tech2nxt.employeeManagement.repository;

import com.tech2nxt.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>  {
}
