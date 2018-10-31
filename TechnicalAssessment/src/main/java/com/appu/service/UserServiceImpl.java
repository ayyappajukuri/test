package com.appu.service;

import java.util.List;

import javax.activation.DataSource;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.bouncycastle.jce.provider.symmetric.CAST5.KeyGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.appu.beans.UserDetails;
import com.appu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	
	 @Autowired
	 private UserRepository userRepository;
	 private DataSource dataSource;
	  @Autowired
	 private JdbcTemplate jdbcTemplate;    
	  
	  private SecretKey key;
	    private Cipher ecipher;
	    private Cipher dcipher;
	    private static KeyGen keyGen;
	    
	public int isAuthorized(String name,String password) {
		int i=0;
		
		 List<UserDetails> result = jdbcTemplate.query(
	             "SELECT id,userName, userFullName FROM user where username = ? and userPassword= ? ", new Object[] {name,password},
	             (rs, rowNum) -> new UserDetails(rs.getInt("id"),rs.getString("userName"), rs.getString("userFullName"))
	     );
		 
		 if(result.size()<=0)
			 return i;
		 
		 else 
			return result.get(i).getId();
		
	
		
	}
	public UserDetails getUserDetails(int authorization,String name) {
	
	
	 List<UserDetails> result = jdbcTemplate.query(
             "SELECT id,userName, userFullName,userPassword,phoneNumber FROM user where username = ? ", new Object[] {name},
             (rs, rowNum) -> new UserDetails(rs.getInt("id"),rs.getString("userName"),rs.getString("userPassword"),rs.getString("userFullName"),rs.getInt("phoneNumber"))
     );
	 
	 if(result.size()<=0)
		 return null;

     return result.get(0);
	
	

	
	
	}
	
	
	
	
	
	
	
}
