package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * springMVC导航的方式
 */
@Controller
@RequestMapping("navigation")
public class NavigationController {

    //3-1.转发到控制器
    @RequestMapping("text03-1")
    public ModelAndView test03_1() {
        System.out.println("text03-1---转发到控制器");
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName","英雄联盟");
        mv.setViewName("forward:/navigation/text01-1");
        return mv;
    }
    //3-2.重定向到控制器
    @RequestMapping("text03-2")
    public ModelAndView test03_2(HttpServletRequest request) {
        System.out.println("text03-2---重定向到控制器");
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName","英雄联盟");
        mv.addObject("teamId","100123");
        mv.setViewName("redirect:/navigation/text01-1");
        return mv;
    }


    //2-1.使用 HttpServletRequest 重定向 丢失数据
    @RequestMapping("text02-1")
    public String test02_2(HttpServletRequest request) {
        request.setAttribute("teamName", "勇士");
        return "redirect:/jsp/ok.jsp";   //当添加了redirect:之后,springMVC将不再处理逻辑视图,而是直接转发到物理资源路径
    }

    //2-2.使用 ModelAndView 重定向  使用ModelAndView的方式,可以在视图中的URL获取数据 数据直接展示在url上
    @RequestMapping("text02-2")
    public ModelAndView test02_2() {
        ModelAndView mv = new ModelAndView();
        // 存储在request域中的值以参数的形式追加在URL后面传递给视图 例:127.0.0.1:8080/springMVC/navigation/text02-2?teamName=勇士&teamId=2002
        mv.addObject("teamName", "黄蜂");
        mv.addObject("teamId", 2002);
//        mv.setViewName("ok");
        mv.setViewName("redirect:/jsp/ok.jsp");
        return mv;
    }



    //1-1.使用 HttpServletRequest ,转发到jsp页面
    @RequestMapping("text01-1")
    public String test01_1(HttpServletRequest request) {
        System.out.println("text01-1执行了-------");
//        return "ok";//默认方式 由视图解析器处理之后将逻辑视图转为物理资源路径
        request.setAttribute("teamName", "曼联");
        return "forward:/jsp/ok.jsp";   //当添加了forward:之后,springMVC将不再处理逻辑视图,而是直接转发到物理资源路径
    }

    //1-2.使用 ModelAndView 转发
    @RequestMapping("text01-2")
    public ModelAndView test01_2() {
        System.out.println("text01-2执行了-------");
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName", "啊哈哈");
        mv.setViewName("ok");
//        mv.setViewName("forward:/jsp/ok.jsp");
        return mv;
    }
}
