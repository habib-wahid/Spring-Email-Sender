package com.example.springapi.repository;
import com.example.springapi.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	void findAllEmployees() {

		Employee employee = new Employee(null,"testname1","testname2","test");
		employeeRepository.save(employee);

		List<Employee> employeeList = employeeRepository.findAll();
		System.out.println("List Size " + employeeList.size());
		assertThat(employeeList).hasSize(1);

	}
}