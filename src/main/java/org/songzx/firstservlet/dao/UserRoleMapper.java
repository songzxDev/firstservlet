package org.songzx.firstservlet.dao;

import org.songzx.firstservlet.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}