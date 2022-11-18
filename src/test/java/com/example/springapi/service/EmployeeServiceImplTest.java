package com.example.springapi.service;
import com.example.springapi.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;
	private EmployeeServiceImpl employeeService;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}

	@Test
	void getAllEmployee() {

		employeeService.getAllEmployee();
		verify(employeeRepository).findAll();
	}

	@Test
	@Disabled
	void createNewEmployee() {
	}

	@Test
	@Disabled
	void findAll() {
	}
}