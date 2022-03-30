package com.app.service;
//Not related to spring security

import com.app.pojos.Role;
import com.app.pojos.UserEntity;
import com.app.pojos.UserRole;

public interface IUserService {
	UserEntity saveUser(UserEntity user);
	Role addRole(Role role);
	String linkUserRole(String userName,UserRole roleName);
	
}
