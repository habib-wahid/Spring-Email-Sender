package com.example.springapi.service;

import com.example.springapi.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployee();
    Employee createNewEmployee(Employee employee);
    List<Employee> findAll();

}
