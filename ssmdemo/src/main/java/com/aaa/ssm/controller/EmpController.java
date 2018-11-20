package com.aaa.ssm.controller;

import com.aaa.ssm.service.EmpService;
import com.aaa.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * discriptoin:
 * author:fy
 * createTime:2018-11-07 15:50
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired//依赖注入
    private EmpService empService;
    /**
     * 雇员列表
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model,HttpServletRequest request){
        map.put("pageSize",5);
        int pageNo=map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        String stringPage=new PageUtil(pageNo,5,empService.getPageCount(map),request).getStringPage();
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("empList",empService.getPage(map));
        return "emp/list";
    }

    @RequestMapping("/toAdd")
    public  String addEmpLoad(){
        return "emp/add";
    }

    @RequestMapping("/addEmp")
     public  String addEmp(@RequestParam Map map){
        empService.addEmp(map);
        return "redirect:/emp/list.do";
     }


      @RequestMapping("/delEmp")
     public  String delEmp(@RequestParam int empNo){
         empService.deleteEmp(empNo);
         return "redirect:/emp/list.do";
     }
     @RequestMapping("/ById")
     public String testById(@RequestParam int empNo,Model model){
         Map map= empService.getById(empNo);
         model.addAttribute("getById",map);
      return "emp/update";
     }

     @RequestMapping("/update")
     public  String updateEmp(@RequestParam Map map){
         empService.updateEmp(map);
         return "redirect:/emp/list.do";
     }

}
