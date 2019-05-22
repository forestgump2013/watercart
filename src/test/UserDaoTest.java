package test;

import junit.framework.TestCase;
import tyt.beep.dao.UserDao;
import tyt.beep.model.User;
import tyt.beep.service.OrderService;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit

public class UserDaoTest extends TestCase {
	
	@Autowired
	OrderService orderService;
	
	@Before
	public void setUp(){
		System.out.println("my test before ..");
		
	}
	
	@After
	public void tearDown(){
		System.out.println("my test after ..");
	}
	
	@Test
	public void testMethod1(){
		
		UserDao userDao=new UserDao();
	//	BasicDataSource
		User user=new User("NASDFAe12341208410983","13817654392");
		
		userDao.getJdbcTemplate();
		int count= userDao.addUser(user);
		
		System.out.println("my test  count:"+count);
		
	}

}
