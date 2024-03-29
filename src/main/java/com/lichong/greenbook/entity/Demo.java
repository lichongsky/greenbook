package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 11:24
 */
@Getter
@Setter
@Table(name = "demo")
@Entity
public class Demo extends BaseEntity {
    String name;
    String address;
}
