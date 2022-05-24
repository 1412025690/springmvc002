package com.kkb.controller;

import com.kkb.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("param")
public class ParamController {

    /**
     * 2.使用对象接收参数: 要求用户请求中的参数名称必须与实体类的属性一致 否则 获取不到(值为: null)
     * @param team
     * @return
     */
    @RequestMapping("text02")
    public ModelAndView text02(Team team) {
        System.out.println("text02----------");
        System.out.println("teamId:"+team);
        return new ModelAndView("ok");
    }


    /**
     * 1. 直接使用方法的参数逐个接收:方法的参数名称必须和用户请求参数的名称一致
     * 好处: 不需要类型转换
     * @param teamId
     * @param teamName
     * @param teamLocation
     * @return
     */
    @RequestMapping("text01")
    public ModelAndView text01(Integer teamId,String teamName,String teamLocation) {
        System.out.println("text01----------");
        System.out.println("teamId:"+teamId);
        System.out.println("teamName:"+teamName);
        System.out.println("teamLocation:"+teamLocation);
        return new ModelAndView("ok");
    }

    @RequestMapping("hello")
    public ModelAndView hello(){
        return new ModelAndView("hello");
    }
}
