package com.kkb.controller;

import com.kkb.pojo.Team;
import com.kkb.vo.QueryVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 处理器方法传参
 */
@Controller
@RequestMapping("param")
public class ParamController {




    @RequestMapping("text09")
    public ModelAndView text09(QueryVO vo) {
        System.out.println("text09----------");
        for (Team team : vo.getTeamList()) {
            System.out.println(team);
        }
        return new ModelAndView("ok");
    }

    /**
     * 8.获取集合类型的参数
     *  添加到集合必须使用 RequestParam 注解
     *  与7不同:
     *         1. 不需要添加 RequestParam 注解
     *         2. 一个是数组 一个是集合
     * @param nameList
     * @return
     */
    @RequestMapping("text08")
    public ModelAndView text08(@RequestParam("teamName") List<String> nameList) {
        System.out.println("text08----------");
        for (String s : nameList) {
            System.out.println(s);
        }
        return new ModelAndView("ok");
    }


    /**
     * 7.获取数组类型的参数
     * @param teamName
     * @return
     */
    @RequestMapping("text07")
    public ModelAndView text07(String[] teamName) {
        System.out.println("text07----------");
        for (String s:teamName) {
            System.out.println(s);
        }
        return new ModelAndView("ok");
    }


    /**
     * 6.获取日期类型的参数
     * @param team
     * @return
     */
    @RequestMapping("text06")
    public ModelAndView text06(Team team) {
        System.out.println("text06----------");
        System.out.println("teamId:"+team);
        return new ModelAndView("ok");
    }

    /**
     * 5.    直接使用URL地址传参
     *      借助 @PathVariable 注解
     *      RequestMapping 映射也需要指定参数
     * @param teamId
     * @param teamName
     * @param teamLocation
     * @return
     */
    @RequestMapping("text05/{id}/{name}/{loc}")
    public ModelAndView text05(@PathVariable("id") Integer teamId,
                               @PathVariable("name") String teamName,
                               @PathVariable("loc") String teamLocation) {
        System.out.println("text05----------");
        System.out.println("teamId:"+teamId);
        System.out.println("teamName:"+teamName);
        System.out.println("teamLocation:"+teamLocation);
        return new ModelAndView("ok");
    }


    /**
     * 3.请求参数和方法名称不一致
     *  RequestParam 矫正参数名
     *      解决方案 :
     *          value : 属性表示请求的参数名
     *          required : 表示参数是否必须 默认为true 必须赋值不赋值报错400
     *                     如果为false 则不会报错 结果为空
     * @param
     * @return
     */
    @RequestMapping("text03")
    public ModelAndView text03(@RequestParam(value = "teamId",required = false) Integer id,
                               @RequestParam("teamName")String name,
                               @RequestParam("Location")String loc) {
        System.out.println("text03----------");
        System.out.println("teamId:"+id);
        System.out.println("teamName:"+name);
        System.out.println("Location:"+loc);
        return new ModelAndView("ok");
    }



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
