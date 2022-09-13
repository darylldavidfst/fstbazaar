package com.fst.bazaar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fst.bazaar.entity.Role;
import com.fst.bazaar.entity.User;
import com.fst.bazaar.repo.RoleRepo;
import com.fst.bazaar.repo.UserRepo;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImplementation(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User findById(int userId) {
		return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User id "+userId+" not found"));
	}

	@Override
	public void saveRole(String name, String description) {
		roleRepo.save(new Role(name, description));
	}

	@Override
	public void saveUser(User rootUser) {
		rootUser.setPassword(passwordEncoder.encode(rootUser.getPassword()));
		userRepo.save(rootUser);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		User user = userRepo.findByEmail(email);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
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
