package org.songzx.firstservlet.dao.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnectUtil {
	private static ThreadLocal<SqlSession> threadLcoal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory SqlSessionFactory;
	/**
	 * 
	 * 加载配置文件
	 */
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * 获取SqlSession
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		// 从当前线程获取
		SqlSession sqlSession = threadLcoal.get();
		if (sqlSession == null) {
			sqlSession = SqlSessionFactory.openSession();
			// 将sqlSession与当前线程绑定
			threadLcoal.set(sqlSession);
		}
		return sqlSession;
	}

	/**
	 * 关闭Session
	 */
	public static void closeSqlSession() {
		// 从当前线程获取
		SqlSession sqlSession = threadLcoal.get();
		if (sqlSession != null) {
			sqlSession.close();
			threadLcoal.remove();
		}
	}
}
