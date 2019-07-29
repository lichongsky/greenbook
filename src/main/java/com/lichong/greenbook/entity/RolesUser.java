package com.lichong.greenbook.entity;

import com.emdata.common.mvc.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles_user")
public class RolesUser extends BaseEntity {
    /**
     * 角色id
     */
    @Column(columnDefinition = "varchar(64) comment '角色id'")
    String rid;
    /**
     * 用户id
     */
    @Column(columnDefinition = "varchar(64) comment '用户id'")
    int uid;
}
