package com.webservice.soulyoga.test.temp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.soulyogaadmin.course.dao.ICourseDao;




/**
 * Test User Service
 * @author Shawn xiao
 * @version 2017-06-15 
 */


@RunWith(SpringJUnit4ClassRunner.class)
// Method 1: use the annotation @ContextConfiguration and call XMl under the resouces folder, which is the classpath resource
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})


//Method 4: use the annotation @ContextConfiguration�� and use File to locate the XMl files under webapp/web-inf
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/spring.xml", "file:src/main/webapp/WEB-INF/spring/spring-hibernate.xml"})
public class TestCourseDao_ {

	@Autowired
	ICourseDao courseDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

		@Before
		public void setUp() throws Exception {
		// Method 2: use the @Before annotation and call XMl under the resouces folder by ClassPathXmlApplicationContext, then initial one instance by get Bean
		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"classpath:root-context.xml", "classpath:spring.xml", "classpath:spring-hibernate.xml" });
		
		
		// Method 3: use the @Before annotation and call XMl under the web-inf folder by FileSystemXmlApplicationContext��  then initial one instance by get Bean
		// ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:src/main/resources/*.xml");  
		// courseDao = (ICourseDao) applicationContext.getBean("courseDao");
		} 

	@After
	public void tearDown() throws Exception {
	}

	@Test	
	public void testGetCourseList1() {
		assertEquals(courseDao.getAllCourseList().size(), 2);
		System.out.println("--------------");;
//		assertEquals(1, 2);
		
	}
	
	@Test	
	public void testHaha() {
		assertEquals(1, 2);
	}


}