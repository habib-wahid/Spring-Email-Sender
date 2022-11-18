package com.example.springapi.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotNull
	@Column(length = 255)
	private String firstName;

	@NotNull
	@Column(length = 255)
	private String lastName;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
	private UserProfile userProfile;

	public User(String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
