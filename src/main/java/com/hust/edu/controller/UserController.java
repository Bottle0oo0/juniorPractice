package com.hust.edu.controller;

import com.hust.edu.entity.Page;
import com.hust.edu.entity.User;
import com.hust.edu.services.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/getUser/{id}",method = RequestMethod.GET )
    public User getUser(@PathVariable Integer id){
        User user = userService.selectById(id);
        return user;
    }

    @RequestMapping(value = "/user/getAll",method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = userService.selectAll();
        return users;
    }
    @RequestMapping(value = "/user/reg/{uname}/{logName}/{pwd}/{db}",method = RequestMethod.POST)
    public String register(@PathVariable("uname") String uname,
                           @PathVariable("logName") String logName,
                           @PathVariable("pwd") String pwd,
                           @PathVariable("db") String db){
        //1、取 取参数
        User user=new User(0,uname,logName,pwd,db);
        //2、调 调业务层
        int rs= userService.add(user);
        //3、转 输入结果
        return String.valueOf(rs);
    }
    //此处有个问题 改为以下则无法添加bootstrap组件。
//    @RequestMapping(value = "/user/users",method = RequestMethod.GET)

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView getUsersList(){
        //服务器内产生的请求
        List<User> users = userService.selectAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/users");
        return mv;
    }

    //保存
    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    public String saveUser(@Param("uid") Integer uid,
                           @Param("uname") String uname,
                           @Param("loginName")String loginName
    ){
        System.out.println(uid+":"+uname+":"+loginName);
        return "OK";

    }

    @RequestMapping(value = "/user/page",method = RequestMethod.GET)
    public Page<User> getUserPage(@RequestParam("p") Integer p,//页码
                                  @RequestParam(value = "key",required = false,defaultValue = "")  String key){
        //设置参数是否必须
        //封装参数
        Page<User> page=new Page<>(p,3);
        page.setKey(key==""||key==null?null:key);
        List<User> users=userService.selectByPage(page);

        //将查询到的数据集放入到page对象中
        page.setResults(users);
        return page;
    }

    //获取分页数据绑定到Thymeleaf模板页 ， 在服务端
    @RequestMapping(value = "/user/show",method = RequestMethod.GET)
    public ModelAndView getPageShow(@RequestParam(value = "page",required = false,defaultValue = "1") Integer p,
                                    @RequestParam(value = "key",required = false,defaultValue = "") String key){
        //设置参数是否必须
        //封装参数
        Page<User> page=new Page<>(p,3);
        page.setKey(key==""||key==null?null:key);
        List<User> users=userService.selectByPage(page);

        ModelAndView mv=new ModelAndView();
        mv.addObject("page",page);
        mv.addObject("users",users);
        mv.setViewName("user/show");
        return mv;
    }

}
