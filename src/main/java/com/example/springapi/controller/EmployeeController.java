package com.example.springapi.controller;
import com.example.springapi.entity.Employee;
import com.example.springapi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/")
    public String greeting(){
        return "Hello, World";
    }

    @GetMapping(value = "/all-employee")
    ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all-employee")
    ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping(value = "/save-employee")
    ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createNewEmployee(employee),HttpStatus.OK);
    }


}
