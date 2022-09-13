package com.fst.bazaar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.bazaar.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}