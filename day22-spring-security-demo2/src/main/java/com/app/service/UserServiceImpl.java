package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RoleRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Role;
import com.app.pojos.UserEntity;
import com.app.pojos.UserRole;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder encoder;

	// user registration
	@Override
	public UserEntity saveUser(UserEntity user) {
		System.out.println("save user " + user);
		user.setActive(true);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public String linkUserRole(String userName,UserRole role) {
		// get user from user name
		UserEntity user = userRepo.findByUserName(userName)
				.orElseThrow(() -> new RuntimeException("User not found!!!!"));
		// get role from role name
		Role userRole=roleRepo.findByRole(role).orElseThrow(() -> new RuntimeException("Role not found!!!!"));
		//user n role : found
		// add role to user
		user.getRoles().add(userRole);
		return "Linked role to User....";
	}

}
