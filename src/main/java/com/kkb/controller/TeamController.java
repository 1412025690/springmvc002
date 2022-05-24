package com.kkb.controller;

import com.kkb.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 告诉springmvc核心处理器,我是处理请求的
 */
@Controller
@RequestMapping("team")
public class TeamController {
    @Autowired
    private TeamService teamService;


    @RequestMapping(value = "add.do",method = RequestMethod.GET)
    public ModelAndView addTeam() {
        System.out.println("TeamController----addTeam----");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("team/add"); //      映射成为物理资源路径: /jsp/team/add.jsp
        return mv;
    }


    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public ModelAndView updateTeam() {
        System.out.println("TeamController----updateTeam----");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("team/update");//      映射成为物理资源路径: /jsp/team/update.jsp
        return mv;
    }

    @RequestMapping("hello")
    public ModelAndView hello() {
        System.out.println("TeamController----add----");
        teamService.add();
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName", "湖人");  // 相当于request.setAttribute("teamName","湖人");
        mv.setViewName("index");    //未来经过SpringMvc视图解析器处理,转换成 物理路径 : index.jsp
        // 经过 internalResourceViewResolver 对象处理之后前后缀就变为   index.jsp
        return mv;
    }
}
