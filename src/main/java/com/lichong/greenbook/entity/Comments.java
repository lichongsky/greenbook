package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/23 11:24
 */
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {
    @Column(columnDefinition = "varchar(64) comment '文章id'")
    String articalId;
    @Column(columnDefinition = "varchar(255) comment '评论内容'")
    String content;
    @Column(columnDefinition = "datetime comment '发表日期'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date publishDate;
    @Column(columnDefinition = "varchar(64) comment '用户id'")
    String userId;
}
