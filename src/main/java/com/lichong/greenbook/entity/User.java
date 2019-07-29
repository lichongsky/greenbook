package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
public class User extends BaseEntity {
    @Column(columnDefinition = "varchar(64) comment '用户名'")
    String username;
    @Column(columnDefinition = "varchar(64) comment '密码'")
    String password;
    @Column(columnDefinition = "varchar(64) comment '账户'")
    String account;
    @Column(columnDefinition = "varchar(64) comment '性别'")
    int gender;
    @Column(columnDefinition = "varchar(1000) comment '头像'")
    String avatar;
    @Column(columnDefinition = "int(11) comment '开启1，禁用0'")
    int enable;
    @Column(columnDefinition = "varchar(255) comment 'email'")
    String email;
    @Column(columnDefinition = "datetime comment '注册日期'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date regTime;

}
