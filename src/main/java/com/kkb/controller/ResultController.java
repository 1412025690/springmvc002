package com.kkb.controller;

import com.kkb.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.*;

/**
 * 处理器方法的返回值
 */
@Controller//表示对象创建交给Spring容器
@RequestMapping("result") //类访问路径
public class ResultController {


    //4. 返回类型void : 原生的Service中跳转方式
    //转发 重定向
    @RequestMapping("text04-1")
    public void text04_1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("服务器端的转发--使用httpServiceRequest进行服务器转发");
        request.getRequestDispatcher("/jsp/ok.jsp").forward(request, response);
    }
    @RequestMapping("text04-2")
    public void text04_2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("服务器端的重定向--使用HttpServletResponse进行重定向跳转");
        response.sendRedirect("/jsp/ok.jsp");
    }
    @RequestMapping("text04-3")
    public void text04_3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("返回void类型测试---直接返回字符串");
        writer.flush();
        writer.close();
    }

    @RequestMapping("text04-4")
    public void text04_4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(302);//设置响应码302表示重定向
        response.setHeader("Location","/jsp/ok.jsp");
    }


    /**
     * 非常常用
     * 3. 返回对象类型,Integer Double 自定义类型 List Map 前后端分离时使用
     *      返回的不是逻辑视图的名称,而是数据的返回, 一般和ajax请求搭配使用, 数据格式为:json
     *      将json格式的数据直接返回给响应体
     *     一定要与ResponseBody注解 jackson-core(jackson核心) jackson-databind(jackson数据转换)  三个一起使用, 否则会报错
     * @return
     */
    @RequestMapping("test03-1")
    public Integer test03_1(){
        return 666;     //传入数据类型为Integer
    }
    @RequestMapping("test03-2")
    public String test03_2(){
        //TODO: bug
        return "test";  //传入数据类型为String
    }
    @ResponseBody
    @RequestMapping("test03-3")
    public Team test03_3(){
        Team team = new Team();
        team.setLocation("迈阿密");
        team.setTeamId(1002);
        team.setTeamName("火箭");
        team.setCreateTime(new Date());
        return team;    //传入数据类型为 自定义类型(对象)
    }

    @RequestMapping("test03-4")
    public List<Team> test03_4(){
        List<Team> list = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            Team team = new Team();
            team.setTeamName("火箭:"+i);
            team.setTeamId(1002+i);
            team.setLocation("迈阿密:"+i);
            team.setCreateTime(new Date());
            list.add(team);
        }
        return list;    //传入数据类型为 自定义类型(对象)
    }

    @RequestMapping("test03-5")
    public Map<String,Team> test03_5(){
        Map<String,Team> map = new HashMap();
        for (int i = 0; i < 5; i++) {
            Team team = new Team();
            team.setTeamName("勇士:"+i);
            team.setTeamId(1000+i);
            team.setLocation("金州:"+i);
            team.setCreateTime(new Date());
            map.put(team.getTeamId()+"",team);
        }
        return map;    //传入数据类型为 自定义类型(对象)
    }



    //2.返回字符串
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


    //1.返回值是ModelAndView : 既有 数据携带 又有 资源跳转 时使用
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
