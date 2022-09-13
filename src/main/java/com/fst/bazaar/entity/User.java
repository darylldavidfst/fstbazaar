package com.fst.bazaar.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Size(min = 8, max = 128, message = "Email should be 8-128 characters")
	@NotNull
	private String email;

	@Column(name = "enabled")
	private boolean enabled;

	@NotBlank(message = "Firstname is required")
	@Size(min = 2, max = 45, message = "Firstname should be 2-45 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Lastname is required")
	@Size(min = 2, max = 45, message = "Lastname should be 2-45 characters")
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	@NotBlank(message = "Password is required")
	private String password;

	@Column(name = "photo")
	@Size(max = 64)
	private String photo;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
}