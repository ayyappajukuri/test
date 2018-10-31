package com.appu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appu.beans.Token;
import com.appu.beans.TokenData;
import com.appu.beans.UserDetails;
import com.appu.repository.UserRepository;
import com.appu.service.UserService;



@RestController
public class UserController {
	
	
	  @Autowired
		private UserRepository userRepository;
	  
	  @Autowired

	    UserService userService;
	  
	  private static final String welcomemsg = "You are Authenticated";
	  private static final String errorMsg = "\"error\": \"Invalid username/password";
	  
	  @GetMapping("POST/users")
	  public TokenData welcomeUser(@RequestParam(name="username", required=true) String userName,@RequestParam(name="password", required=true) String password) {

		  int i=userService.isAuthorized(userName,password);
		  
		 if(i==0)
			 return new TokenData(String.format(errorMsg, userName),i);
		 
	        return new TokenData(String.format(welcomemsg, userName),generateKey(userName));
	      

	    }
	  
	  
	  @GetMapping("GET/user")
	  public UserDetails getUser(@RequestParam(name="name", required=true) String userName,@RequestHeader(value="authorization") String authorization) {
		  final String errorMsgUsers ="message No users found";
		  UserDetails userDetails=null;
		  boolean flag=verifyKey(userName,authorization);
		  int i=0;
		  if(flag)
		   userDetails=userService.getUserDetails(i,userName);
		  
		  if(userDetails==null)
			  return new Token(String.format(errorMsgUsers, userName),0);
		  
	        return  userDetails;
	      

	    }
	  
	  
	  public String generateKey(String userName) {
		  String key="";
		  if(userName.length()>1) {
			  key=userName.substring(1, userName.length()-1/2);
			 
			  
		  }
		  
		 return key;
		  
		  
	  }
	  
	  
	  public boolean verifyKey(String userName,String key) {
		  boolean flag=false;
		  String keyGenerated="";
		  if(userName.length()>1) {
			  keyGenerated=userName.substring(1, userName.length()-1/2);
			 }
		  
		  if(key.equalsIgnoreCase(keyGenerated))
			  return true;
		  
		  return flag;
	  }

}
