package com.example.springapi.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;


	@Test
	public void TestRepo(){
		assertThat(userRepository).isNotNull();
	}

}