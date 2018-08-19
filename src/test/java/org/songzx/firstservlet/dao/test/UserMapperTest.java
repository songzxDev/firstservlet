package org.songzx.firstservlet.dao.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.songzx.firstservlet.service.UserServiceI;
import org.songzx.firstservlet.service.UserServiceImpl;

public class UserMapperTest {
	private static Logger logger = Logger.getLogger(UserMapperTest.class);
	private UserServiceI userService = new UserServiceImpl();
    
	@Test
	public void testDeleteByPrimaryKey() {
		logger.info("Not yet implemented");
	}

	@Test
	public void testInsert() {
		logger.info("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		logger.info("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		try {
			userService.getUserById("1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		logger.info("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		logger.info("Not yet implemented");
	}

}
