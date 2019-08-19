package com.satish.ws.userservice;

import com.satish.ws.ui.model.request.UserDetailsRequestModel;
import com.satish.ws.ui.model.response.UserRest;

public interface UserService {
UserRest createUser(UserDetailsRequestModel userDetails);
}
