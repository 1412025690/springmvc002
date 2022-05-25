package com.kkb.Exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = TeamIdException.class)
    public ModelAndView exHandler1(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("idError");
        return mv;
    }
    @ExceptionHandler(value = TeamNameException.class)
    public ModelAndView exHandler2(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exHandler3(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = TeamException.class)
    public ModelAndView exHandler4(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("teamError");
        return mv;
    }
}
