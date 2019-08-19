package com.satish.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.ws.shared.Utils;
import com.satish.ws.ui.model.request.UserDetailsRequestModel;
import com.satish.ws.ui.model.response.UserRest;
import com.satish.ws.userservice.UserService;

@Service
public class UserServImpl implements UserService {
	Map<String, UserRest> users;
	Utils utils;
	public UserServImpl() {
		
	}
	@Autowired
	public UserServImpl(Utils utils)
	{
		this.utils=utils;
	}
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail() );
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		if(users==null) users = new HashMap<>();
		users.put(userId, returnValue );
		return returnValue;
	}

}
