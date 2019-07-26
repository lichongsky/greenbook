package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 17:21
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class Tags extends BaseEntity {
    String tagName;
}
