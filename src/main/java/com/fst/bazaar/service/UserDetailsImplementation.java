package com.fst.bazaar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fst.bazaar.entity.User;
import com.fst.bazaar.repo.UserRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserDetailsImplementation implements UserDetailsService {
	private final UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException(email);
		}

		System.out.println(user);

		List<SimpleGrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.toList();

		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), authorities);
	}
}