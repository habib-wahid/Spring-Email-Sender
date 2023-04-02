package com.example.springapi.controller;
import com.example.springapi.BatchConfiguration;
import com.example.springapi.entity.Employee;
import com.example.springapi.service.EmployeeServiceImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    BatchConfiguration batchConfiguration;

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;


    @GetMapping("/welcome")
    public void sendEmail(){
        JobParameters Parameters = new JobParametersBuilder()
          .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, Parameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException
          | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

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
