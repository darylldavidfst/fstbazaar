package com.fst.bazaar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.fst.bazaar.service.RoleService;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Rollback(value = false)
@ActiveProfiles("test")
class RoleServiceTest {
	@Autowired
	RoleService roleService;

	@Test
	void testFillRoles() {
		roleService.fillRoles();
		Assertions.assertThat(roleService.findAll()).size().isEqualTo(4);
	}

	@Test
	void shouldDeleteAllRoles() {
		roleService.deleteAll();
		Assertions.assertThat(roleService.findAll()).size().isNotPositive();
	}
}