package com.kkb.controller;

import com.kkb.Exception.TeamException;
import com.kkb.Exception.TeamIdException;
import com.kkb.Exception.TeamNameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试异常处理控制器
 */
@Controller
@RequestMapping("ex")
public class ExController {
    @RequestMapping("test01/{id}/{name}/{loc}")
    public ModelAndView test01(@PathVariable("id") Integer teamId,@PathVariable("name") String teamName,@PathVariable("loc")String loc) throws TeamException {
        ModelAndView mv = new ModelAndView();
        if(teamId <= 1000){
            mv.setViewName("idError");
            throw new TeamIdException("teamId不合法!必须在1000以上");
        }
        if("test".equals(teamName)){
            mv.setViewName("nameError");
            throw new TeamNameException("teamName不合法!必须不是test");
        }
        if("test".equals(loc)){
            mv.setViewName("locError");
            throw new TeamException("team属性错误!请仔细检查!");
        }
        mv.setViewName("ok");
        return mv;
    }
}
