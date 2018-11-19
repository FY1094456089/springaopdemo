package com.aaa.mb.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:雇员数据访问接口
 * author:fy
 * createTime:2018-11-05 16:40
 */
public interface EmpDao {
    /**
     * 获取雇员列表(if用法)
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 获取雇员信息(choose when otherwise 用法)
     * @param map
     * @return
     */
    List<Map> getListByParam(Map map);

    /**
     * foreach用法
     * @param list
     * @return
     */
    List<Map> getListByList(List list);
}
