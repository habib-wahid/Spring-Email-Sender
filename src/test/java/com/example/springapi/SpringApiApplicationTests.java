package com.example.springapi;

import com.example.springapi.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringApiApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    @Test
    void contextLoads() throws Exception{
        assertThat(employeeController).isNotNull();
    }

}
