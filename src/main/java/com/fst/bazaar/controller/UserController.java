package com.fst.bazaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fst.bazaar.entity.User;
import com.fst.bazaar.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@GetMapping("/list")
	public String listAll(Model model) {
		List<User> listUsers = userService.findAll();
		model.addAttribute("listUsers", listUsers);

		return "users/list-users";
		//return "list-users";
	}
}
