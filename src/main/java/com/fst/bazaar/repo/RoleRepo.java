package com.fst.bazaar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.bazaar.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	Role findByName(String name);
}
