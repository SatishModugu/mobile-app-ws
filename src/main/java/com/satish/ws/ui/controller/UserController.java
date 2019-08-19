package com.satish.ws.ui.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.satish.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.satish.ws.ui.model.request.UserDetailsRequestModel;
import com.satish.ws.ui.model.response.UserRest;
import com.satish.ws.userservice.UserService;
import com.satish.ws.userservice.impl.UserServImpl;

@RestController // Register class a RestCcontroller able to receive HTTP request
@RequestMapping("/users") // http://localhost8080/users/
public class UserController
{
	Map<String, UserRest> users;
	@Autowired
	UserService userService;
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "1") int limit,
			@RequestParam(value = "sort", required = false) String sort)
	{
		// Not initialized primitive data types can not be translated to null,
		// so required is mostly used with string types
		return "get users was called with page =" + page + "limit =" + limit;
	}

	@GetMapping(path = "/{userId}", 
			produces= 
		{MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		if(users.containsKey(userId))
		return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		else
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
			
	}
   // Add media types : produces, cosumes
	@PostMapping(consumes= 
		{MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces= 
		{MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<UserRest>  createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}",consumes= 
		{MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces= 
		{MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
	{
		UserRest storedUserDetails= users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}
