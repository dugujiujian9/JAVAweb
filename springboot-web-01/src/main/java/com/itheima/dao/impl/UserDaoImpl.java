package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
//@Component//将当前类交给IOC容器实现
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
//        1、读取user.txt文件，加载用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        读D:\learn\graduate1\java\javaAI\web-project-01\springboot-web-01\src\main\resources/user.txt文件
        ArrayList<String> lines= IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
