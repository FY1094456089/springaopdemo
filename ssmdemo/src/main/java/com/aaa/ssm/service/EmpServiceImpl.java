package com.aaa.ssm.service;

import com.aaa.ssm.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:fy
 * createTime:2018-11-07 15:16
 */
@Service //交给spring管理
public class EmpServiceImpl implements  EmpService {

    @Autowired//依赖注入
    private EmpDao empDao;
    @Override
    public List<Map> getPage(Map map) {
        //如果pageNo为空默认1 pageSize为空 默认10
       int pageNo= map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
       int pageSize= map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
      //计算分页的开始值和结束值
       map.put("start",(pageNo-1)*pageSize);
       map.put("end",pageNo*pageSize+1);
        return empDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return empDao.getPageCount(map);
    }

    @Override
    public int addEmp(Map map) {
        int add=empDao.addEmp(map);
        System.out.println(1/0);
        System.out.println("返回的ID"+map.get("empNo"));
        return add;
    }

    @Override
    public Map getById(int empNo) {
        return empDao.getById(empNo);
    }

    @Override
    public int deleteEmp(int empNo) {
        return empDao.deleteEmp(empNo);
    }

    @Override
    public int updateEmp(Map map) {
        return empDao.updateEmp(map);
    }
}
