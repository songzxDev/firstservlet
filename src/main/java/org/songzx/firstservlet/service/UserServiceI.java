package org.songzx.firstservlet.service;

import org.songzx.firstservlet.model.User;

public interface UserServiceI {
	public User getUserById(String uid) throws Exception;
}
