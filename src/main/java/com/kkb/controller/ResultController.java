package com.kkb.controller;

import com.kkb.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * 处理器方法的返回值
 */
@Controller//表示对象创建交给Spring容器
@RequestMapping("result") //类访问路径
public class ResultController {


    //返回字符串
    @RequestMapping("text02")
    public String test02(HttpServletRequest request){
        Team team = new Team();
        team.setLocation("迈阿密");
        team.setTeamId(1002);
        team.setTeamName("火箭");
        //携带数据
        //同名不在同一个作用域里
        request.setAttribute("team",team);
        request.getSession().setAttribute("team",team);
        //资源跳转
        return "result";// 经过视图解析器(视图解析器在springmvc.xml类) internalResourceViewResolver 处理,将逻辑视图名称加上前后缀变为物理资源路径
    }


    //返回值是ModelAndView : 既有 数据携带 又有 资源跳转 时使用
    @RequestMapping("text01")   //方法访问路径
    public ModelAndView text01(){
        ModelAndView mv = new ModelAndView();  //模型与视图对象 模型 : 存储数据 视图 : 给用户展示的内容 分为两部分
        /**
         *  经过视图解析器处理
         *  视图解析器在springmvc.xml类 中的 beanid = internalResourceViewResolver
         *  将逻辑视图名称加上前后缀变为物理资源路径
         *  /jsp/result/text01.jsp
         */
        mv.setViewName("result");// 经过视图解析器(视图解析器在springmvc.xml类) internalResourceViewResolver 处理,将逻辑视图名称加上前后缀变为物理资源路径
        //携带数据
        mv.addObject("teamName","湖人队"); //相当于request.setAttribute("teamName","湖人队");
        return mv;
    }
}
