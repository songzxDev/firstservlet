package org.songzx.firstservlet.dao;

import org.songzx.firstservlet.model.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}