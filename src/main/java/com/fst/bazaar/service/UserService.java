package com.fst.bazaar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fst.bazaar.entity.User;

@Service
public interface UserService {
	User findByEmail(String email);
	User findById(int userId);
	void saveUser(User rootUser);
	void deleteAll();
	List<User> findAll();
}