package com.fst.bazaar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fst.bazaar.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}