package com.aaa.mb.test;

import com.aaa.mb.dao.NewsDao;
import com.aaa.mb.entity.News;
import com.aaa.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:NewsDaoTest
 * discriptoin:
 * author:fy
 * createTime:2018-11-05 20:05
 */
public class NewsDaoTest {
    @Test //查询
    public void getList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map paramMap = new HashMap();
            paramMap.put("title", "ttt");
            List<Map> list = newsDao.getList(paramMap);
            for (Map map : list) {
                System.out.println("编号：" + map.get("NEWID") + ",内容：" + map.get("CONTENT") + ",类型编号：" + map.get("TYPEID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test //添加
    public void addList() {
        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map paramMap = new HashMap();
            // dept.setDeptNo(6);
            paramMap.put("title", "ttt");
            paramMap.put("content", "我最帅");
            paramMap.put("typeid", 2);
            //调用添加方法
            int result = newsDao.add(paramMap);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test //修改
    public void listUpdate() {
        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map map = newsDao.getById(27);
            // dept.setDeptNo(6);
            map.put("title", "ddd");
            map.put("content", "我最帅");
            map.put("typeid", 2);
            int result = newsDao.update(map);
            //提交事务
            sqlSession.commit();
            if (result > 0) {
                System.out.println("更新成功！");
            } else {
                System.out.println("更新失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test  //删除
    public void listDelete() {


        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);

            int result = newsDao.delete(16);
            //提交事务
            sqlSession.commit();
            if (result > 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test //查询
    public void testManyToOne() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);

            List<News> news = newsDao.manyToOne();
            if (news != null && news.size()>0) {
                for (News news1 : news){
                    System.out.println("新闻标题" + news1.getTitle() + ",内容：" + news1.getContent() + ",分类名称：" + news1.getNewsType().getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}