package com.jhmarryme.cola.web.gatewayimpl.database.mybatis.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Table;

@Data
@TableName("user_mybatis")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}