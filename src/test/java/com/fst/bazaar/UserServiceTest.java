package com.fst.bazaar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.fst.bazaar.entity.Roles;
import com.fst.bazaar.entity.User;
import com.fst.bazaar.service.UserService;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Rollback(value = false)
@ActiveProfiles("test")
class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	void shouldSaveUser() {
		String newEmail = "superuser@gmail.com";

		User root = new User();
		root.setEmail(newEmail);
		root.setEnabled(true);
		root.setFirstName("Super");
		root.setLastName("User");
		root.setPassword(newEmail);

		userService.saveUser(root);
		userService.addRoleToUser(newEmail, Roles.Admin.name());

		User user = userService.findByEmail(newEmail);
		Assertions.assertThat(newEmail).isEqualTo(user.getEmail());
	}

	@Test
	void shouldDeleteAllUsers() {
		userService.deleteAll();
		Assertions.assertThat(userService.findAll()).size().isNotPositive();
	}
}