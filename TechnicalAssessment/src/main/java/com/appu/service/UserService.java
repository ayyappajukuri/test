package com.appu.service;

import com.appu.beans.UserDetails;

public interface UserService {
	
	
	
	public int isAuthorized(String name,String password);
	public UserDetails getUserDetails(int authorizationId,String name);

}
