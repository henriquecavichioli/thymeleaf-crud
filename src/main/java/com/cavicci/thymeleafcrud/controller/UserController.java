package com.cavicci.thymeleafcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cavicci.thymeleafcrud.domain.User;
import com.cavicci.thymeleafcrud.service.UserService;

import javassist.NotFoundException;

@Controller
public class UserController {
	@Autowired
	private UserService service;


	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		service.saveUser(user);
		return "redirect:/index";
	}


	@GetMapping("/index")
	public String showUserList(Model model) throws NotFoundException {
		model.addAttribute("users", service.findAllUsers());
		return "index";
	}
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		service.saveUser(user);
		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) throws NotFoundException {
		User user = service.findById(id);
		service.deleteUser(user);
		return "redirect:/index";
	}




}
