package com.fst.bazaar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_users")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "login_enabled")
	private boolean loginEnabled;

	@Column(name = "email")
	@Size(min = 8, max = 255, message = "Email should be 8-255 characters")
	@NotNull
	private String email;

	@Column(name = "password")
	@NotBlank(message = "Password is required")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	private Date updatedAt;

	@Column(name = "deleted_at")
	private Date deletedAt;
}