package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Role;
import com.app.pojos.UserEntity;
import com.app.pojos.UserRole;

@SpringBootTest
public class ServiceLayerTests {
	@Autowired
	private IUserService userService;

	@Test
	void testSaveUser() {
		UserEntity transientUser = new UserEntity("Rama", "rama@gmail.com", "1234567");
		UserEntity persistentUser = userService.saveUser(transientUser);
		System.out.println();
		assertEquals(1, persistentUser.getId());
	}
	@Test
	void testAddCustomerRole()
	{
		Role role1 = userService.addRole(new Role(UserRole.ROLE_CUSTOMER));
		System.out.println(role1);
	}
	@Test
	void testAddAdminRole()
	{
		Role role1 = userService.addRole(new Role(UserRole.ROLE_ADMIN));
		System.out.println(role1);
	}
	@Test
	void testLinkUserRole()
	{
		//add admin role to Rama
		System.out.println(userService.linkUserRole("Rama",UserRole.ROLE_ADMIN));
	}

}
