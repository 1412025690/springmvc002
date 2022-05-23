package com.kkb.controller;

import com.kkb.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/team")
    public ModelAndView add() {
        System.out.println("TeamController----add----");
        teamService.add();
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName","湖人");  // 相当于request.setAttribute("teamName","湖人");
        mv.setViewName("index");    //未来经过SpringMvc视图解析器处理,转换成 物理路径 : index.jsp
        return mv;
    }
}
