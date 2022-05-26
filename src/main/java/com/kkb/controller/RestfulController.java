package com.kkb.controller;

import com.kkb.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * REST ful风格的控制器
 */
@Controller
public class RestfulController {
    private static List<Team> teamList;
    //TODO : 全都是bug 添加功能正常 更新功能-未完整测试-目前正常
    static{
        teamList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Team team = new Team();
            team.setTeamId(1000+i);
            team.setTeamName("湖人"+i);
            team.setLocation("洛杉矶"+i);
            teamList.add(team);
        }
    }


    /**
     * 根据ID删除一个球队
     */
    @RequestMapping(value = "/team/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String del(@PathVariable("id")int id){
        System.out.println("删除DELETE---发起的请求----------");
        for (Team team : teamList) {
            if(team.getTeamId()==id){
                teamList.remove(team);
                return "204";
            }
        }


        return "500";
    }



    /**
     * 根据id更新一个球队
     */
    @RequestMapping(value = "/team/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String add(@PathVariable("id")int id,Team team){
        System.out.println("更新PUT---发起的请求----------");
        teamList.add(team);

        for (Team team1:teamList) {
            if(team1.getTeamId() == id){
                team.setLocation(team.getLocation());
                team1.setTeamName(team.getTeamName());
                return "200";
            }
        }
        return "400";
    }



    /**
     * 添加一个球队
     */
    @RequestMapping(value = "/team",method = RequestMethod.POST)
    @ResponseBody
    public String add(Team team){
        System.out.println("添加POST---发起的请求----------");
        teamList.add(team);
        return "201";
    }

    /**
     * 查询所有的球队
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teams",method = RequestMethod.GET)
    public List<Team> getAll(){
        System.out.println("查询所有GET按钮---发起的请求----------");
        return teamList;
    }

    /**
     * 根据 id 查询单个球队
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/team/{id}",method = RequestMethod.GET)
    public Team getOne(@PathVariable("id")int id){
        System.out.println("查询单个GET---发起的请求---------");
        for (Team team:teamList) {
            if(team.getTeamId() == id){
                return team;
            }
        }
        return null;
    }


    @RequestMapping("hello")
    public String hello(){
        return "restful";
    }
}
