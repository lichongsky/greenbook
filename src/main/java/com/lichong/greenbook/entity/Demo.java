package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 11:24
 */
@Data
@Table(name="demo")
@Entity
public class Demo extends BaseEntity {
    String name;
    String address;
    Date createTime;
    Date updateTime;

}
