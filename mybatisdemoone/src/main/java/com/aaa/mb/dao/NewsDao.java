package com.aaa.mb.dao;

import com.aaa.mb.entity.News;

import java.util.List;
import java.util.Map;

/**
 * className:NewsDao
 * discriptoin:
 * author:fy
 * createTime:2018-11-05 19:54
 */
public interface NewsDao {
    /**
     * 查询所有
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     *
     * @param NEWID
     * @return
     */
    Map getById(int NEWID);

    /**
     * 删除
     * @param NewId
     * @return
     */
    int delete(int NewId);

    /**
     * 修改
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 多对一
     * @return
     */
 List<News> manyToOne();
}
