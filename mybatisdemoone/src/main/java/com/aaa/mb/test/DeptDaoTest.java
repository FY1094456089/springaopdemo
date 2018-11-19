package com.aaa.mb.test;

import com.aaa.mb.dao.DeptDao;
import com.aaa.mb.entity.Dept;
import com.aaa.mb.entity.Emp;
import com.aaa.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * className:DeptDaoTest
 * discriptoin:
 * author:fy
 * createTime:2018-11-03 16:50
 */
public class DeptDaoTest {
    public static void main(String[] args) {
      /* -----------查询------------
      SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
             sqlSession= SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            List<Dept> list=deptDao.getList();
            //循环打印
            for (Dept dept : list) {
                System.out.println("名称："+dept.getDname()+",位置"+dept.getLoc());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }*/
        //------------添加---------------
        /*SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
             Dept dept=new Dept();
            // dept.setDeptNo(6);
             dept.setDname("开发33部");
             dept.setLoc("33楼");
             //调用添加方法
             int result=deptDao.add(dept);
             //提交事务
             sqlSession.commit();
             if (result>0){
                 System.out.println("添加成功！");
             }else {
                 System.out.println("添加失败！");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
*/
        //-------------更新---------------------
        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            Dept dept = deptDao.getById(60);
            // dept.setDeptNo(6);
            dept.setDname("开发33部");
            dept.setLoc("33楼");
            int result = deptDao.update(dept);
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

    //-------------删除--------------------
    @Test
    public void testDelete() {

        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);

            int result = deptDao.delete(4);
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

    @Test
    public void testOneToMoany() {
        SqlSession sqlSession = null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            List<Dept> list = deptDao.oneToMany();
            if (list != null && list.size() > 0) {
                for (Dept dept : list) {
                    System.out.println("名称：" + dept.getDname() + ",位置" + dept.getLoc());
                    List<Emp> empList = dept.getEmpList();
                    if (empList != null && empList.size() > 0) {
                        System.out.println("该部门共：" + empList.size() + "人，员工如下：");
                        for (Emp emp : empList) {
                            System.out.println("----------员工姓名：" + emp.getEname() + "工资："
                                    + emp.getSalary() + "奖金：" + emp.getComm());
                        }
                    } else {
                        System.out.println("该部门下没有员工！！");
                    }
                    System.out.println("---------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}

