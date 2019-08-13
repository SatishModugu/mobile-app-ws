package com.satish.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satish.ws.ui.model.response.UserRest;

@RestController // Register class a RestCcontroller able to receive HTTP request
@RequestMapping("/users") // http://localhost8080/users/
public class UserController
{
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "1") int limit,
			@RequestParam(value = "sort", required = false) String sort)
	{
		// Not initialized primitive data types can not be translated to null,
		// so required is mostly used with string types
		return "get users was called with page =" + page + "limit =" + limit;
	}

	@GetMapping(path = "/{userId}", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		UserRest returnValue = new UserRest();
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("Satish");
		returnValue.setLastName("modugu");
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
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
