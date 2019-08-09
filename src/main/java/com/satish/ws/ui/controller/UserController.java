package com.satish.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Register class a RestCcontroller able to receive HTTP request
@RequestMapping("users")//http://localhost8080/users/
public class UserController {
	@GetMapping
	public String getUser()
	{
		return "get user was called";
	}
	@PostMapping
	public String createUser()
	{
		return "creat user was called";
	}
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}
}