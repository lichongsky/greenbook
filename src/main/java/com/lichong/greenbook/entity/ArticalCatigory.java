package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/23 11:12
 */

@Getter
@Setter
@Entity
@Table(name = "artical_catigory")
public class ArticalCatigory extends BaseEntity {
    @Column(columnDefinition = "varchar(255) comment '分类名称'")
    String catigoryName;
}
