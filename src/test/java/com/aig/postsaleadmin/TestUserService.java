package com.aig.postsaleadmin;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.soulyogaadmin.employee.service.IEmployeeAccountService;
import com.web.soulyogaadmin.employee.service.impl.EmployeeAccountServiceImpl;
import com.web.soulyogaadmin.user.service.IUserService;
import com.web.soulyogaadmin.user.service.UserServiceImpl;



/**
 * Test User Service
 * @author Shawn xiao
 * @version 2017-06-15
 */

public class TestUserService {

//	IUserService userService = new UserServiceImpl();
	
	IEmployeeAccountService employeeAccService = new EmployeeAccountServiceImpl();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:spring.xml", "classpath:spring-hibernate.xml" });
		employeeAccService = (IEmployeeAccountService) ac.getBean("employeeAccountService");
	} 

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserLogin() {
		assertTrue(employeeAccService.employeeAccountLogin("Admin", "Admin"));	
	}

	@Test
	public void testUserForgetPassword() {
//		String newPassword = userService.userForgetPassword("adminTest2");
//		assertNotNull(newPassword);
//		assertTrue(userService.userLogin("adminTest2", newPassword));	
	}

	@Test
	public void testUserResetPassword() {
//		assertTrue(userService.userResetPassword("adminTest2", "newpassword"));
//		assertTrue(employeeAccService.employeeAccountLogin("Admin", "Admin"));	
	}

}
