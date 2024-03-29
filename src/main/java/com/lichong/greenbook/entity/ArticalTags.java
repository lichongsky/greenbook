package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/23 11:23
 */
@Getter
@Setter
@Entity
@Table(name = "artical_tags")
public class ArticalTags extends BaseEntity {
    @Column(columnDefinition = "varchar(64) comment '文章id'")
    String articalId;
    @Column(columnDefinition = "varchar(64) comment '文章分类id'")
    String articalCatigoryId;
}
