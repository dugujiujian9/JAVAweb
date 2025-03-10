package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//实体类，定义用户信息
@Data//getter/setter/toString/equals/hashCode/
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;//包装类比基本类型的优势在于没有默认值
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
