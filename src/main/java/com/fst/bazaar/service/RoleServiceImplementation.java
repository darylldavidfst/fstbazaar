package com.fst.bazaar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fst.bazaar.entity.Role;
import com.fst.bazaar.entity.Roles;
import com.fst.bazaar.repo.RoleRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImplementation implements RoleService {
	private final RoleRepo roleRepo;

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findOne(int id) {
		return roleRepo.findById(id).orElseThrow(RuntimeException::new);
	}

	@Override
	public Role findByName(String name) {
		return roleRepo.findByName(name);
	}

	@Override
	public void deleteAll() {
		roleRepo.deleteAll();
	}

	@Override
	public void fillRoles() {
		roleRepo.save(new Role(Roles.Admin.name(), Roles.Admin.DESCRIPTION));
		roleRepo.save(new Role(Roles.Salesperson.name(), Roles.Salesperson.DESCRIPTION));
		roleRepo.save(new Role(Roles.Editor.name(), Roles.Editor.DESCRIPTION));
		roleRepo.save(new Role(Roles.Shipper.name(), Roles.Shipper.DESCRIPTION));
	}

	@Override
	public ArrayList<Integer> getRolesIds() {
		return roleRepo.findAll().stream().map(Role::getId).collect(Collectors.toCollection(ArrayList::new));
	}
}