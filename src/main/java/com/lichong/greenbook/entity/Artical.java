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
 * @date ：Created in 2019/7/23 11:03
 */

@Getter
@Setter
@Entity
@Table(name = "artical")
public class Artical extends BaseEntity {

    @Column(columnDefinition = "varchar(255) comment '标题'")
    String title;
    @Column(columnDefinition = "text comment 'md内容'")
    String mdContent;
    @Column(columnDefinition = "text comment 'html内容'")
    String htmlContent;
    @Column(columnDefinition = "text comment '内容'")
    String summary;
    @Column(columnDefinition = "varchar(64) comment 'categoryId'")
    int cid;
    @Column(columnDefinition = "varchar(64) comment 'userId'")
    int uid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date publishDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date editDate;
    @Column(columnDefinition = "int(5) comment '状态'")
    int state;
    @Column(columnDefinition = "int(11) comment '已看次数'")
    int pageView;
    @Column(columnDefinition = "int(11) comment '点赞次数'")
    int likeNumber;
}
