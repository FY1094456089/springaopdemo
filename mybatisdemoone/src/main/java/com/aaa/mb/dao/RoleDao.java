package com.aaa.mb.dao;

import com.aaa.mb.entity.Role;

import java.util.List;

/**
 * className:RoleDao
 * discriptoin:
 * author:fy
 * createTime:2018-11-06 16:58
 */
public interface RoleDao {
    /**
     * 多对多
     * @return
     */
    List<Role> manyToMany();
}
