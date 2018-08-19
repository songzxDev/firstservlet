package org.songzx.firstservlet.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.songzx.firstservlet.dao.UserMapper;
import org.songzx.firstservlet.dao.util.DBConnectUtil;
import org.songzx.firstservlet.model.User;

import com.alibaba.fastjson.JSON;

public class UserServiceImpl implements UserServiceI {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User getUserById(String uid) throws Exception {
		User user = null;
		SqlSession session = DBConnectUtil.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			user = userMapper.selectByPrimaryKey(Integer.parseInt(uid));
			logger.info(JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectUtil.closeSqlSession();
		}
		return user;
	}

}
