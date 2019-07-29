package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name="book")
@Entity
public class Book extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cid")
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid",strategy = "com.emdata.common.hibernate.UUIDSequence")
    private Category categoryId;

    @Column(columnDefinition = "varchar(255) comment '封面图片url'")
    String cover;
    @Column(columnDefinition = "varchar(255) comment '标题'")
    String title;
    @Column(columnDefinition = "varchar(255) comment '作者'")
    String author;
    @Column(columnDefinition = "datetime comment '出版日期'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date publishDate;
    @Column(columnDefinition = "varchar(255) comment '出版社'")
    String press;
    @Column(columnDefinition = "text comment '简介'")
    String abs;
}
