package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:雇员持久层
 * author:fy
 * createTime:2018-11-07 14:59
 */
public interface EmpDao {
    /**
     * 雇员列表
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 添加雇员
     * @param map
     * @return
     */
    int addEmp(Map map);

    /**
     * 根据id查
     * @param empNo
     * @return
     */
    Map getById(int empNo);

    /**
     * 删除雇员
     * @param empNo
     * @return
     */
    int deleteEmp(int empNo);

    /**
     * 修改用户
     * @param map
     * @return
     */
    int updateEmp(Map map);
}
