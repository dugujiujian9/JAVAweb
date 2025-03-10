package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.Impl.UserServiceImpl;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息Controller
 */
@RestController
public class UserController {
    /*
    @RequestMapping("/list")//需求是http://localhost:8080/list
    public List<User> list() throws Exception {
//        1、读取user.txt文件，加载用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        读D:\learn\graduate1\java\javaAI\web-project-01\springboot-web-01\src\main\resources/user.txt文件
        ArrayList<String> lines=IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        2、解析用户信息，封装为User对象-》list对象
        List<User> userList=lines.stream().map(line->{
            String[] parts = line.split(",");
            Integer id=Integer.parseInt(parts[0]);
            String username= parts[1];
            String password= parts[2];
            String name= parts[3];
            Integer age=Integer.parseInt(parts[4]);
            LocalDateTime updateTime=LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
//        返回数据
        return userList;
    }*/
/*
    方式一：属性注入
    @Autowired//应用程序运行时会自动注入
    private UserService userService;
 */

/*      方式二：构造函数注入
    private final UserService userService;
   @Autowired-->如果当前类中只存在一个构造函数，@Autowired可以省略
    public UserController(UserService userService) {
        this.userService = userService;
    }
*/

/*
    方式三：set方法注入
 */
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")//需求是http://localhost:8080/list
    public List<User> list() throws Exception {
//        1.调用service层方法，获取用户列表
        List<User> userList=userService.findAll();
//        返回数据
        return userList;
    }
}
