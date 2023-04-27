package com.example.testingSecurtiy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testingSecurtiy.model.ReturnUserDetails;
import com.example.testingSecurtiy.model.UserModel;
import com.example.testingSecurtiy.service.MySecurityService;

@RestController
@RequestMapping("/home")
public class UserContoller {
	@Autowired
	MySecurityService service;

	@GetMapping("/user")
	public String userModel() {
		return "Only user can access this";
	}

	@GetMapping("/admin")
	public String adminModel() {
		return "Only admin can access this";
	}

	@GetMapping("/all")
	public String allUser() {
		return "All clients can access this";
	}

	@PostMapping("/add/user")
	public UserModel addUser(@RequestBody UserModel models) {
		return service.addUser(models);
	}

	@GetMapping("/get/user")
	public List<UserModel> getUseretails() {
		return service.getUser();
	}
}
