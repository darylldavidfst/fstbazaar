package com.fst.bazaar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fst.bazaar.entity.User;
import com.fst.bazaar.repo.UserRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User findById(int userId) {
		return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User id " + userId + " not found"));
	}

	@Override
	public void saveUser(User rootUser) {
		rootUser.setPassword(passwordEncoder.encode(rootUser.getPassword()));
		userRepo.save(rootUser);
	}

	@Override
	public void deleteAll() {
		userRepo.deleteAll();
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}
}
