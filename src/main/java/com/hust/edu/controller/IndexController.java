package com.hust.edu.controller;

import com.hust.edu.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public @ResponseBody
    String index(){
        return "<h1>welcome hi!<h1>";
    }

    @RequestMapping("/home")
    public ModelAndView getIndex(){
        //实例化模型视图和对象
        ModelAndView mv = new ModelAndView();
        //放入数据 key-value模式
        mv.addObject("title","welcom");
        //指定显示视图
        mv.setViewName("index");
        return mv;
    }




}











