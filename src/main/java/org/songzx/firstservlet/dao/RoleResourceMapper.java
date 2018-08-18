package org.songzx.firstservlet.dao;

import org.songzx.firstservlet.model.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}