package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="category")
@Entity
public class Category extends BaseEntity{

    @Column(columnDefinition = "varchar(255) comment '分类名'")
    String name;
}
