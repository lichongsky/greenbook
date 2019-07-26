package com.lichong.greenbook.vo;

import com.emdata.common.mvc.entity.BaseEntity;
import com.emdata.common.mvc.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lichong.greenbook.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 16:02
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo extends BaseVo {
    String username;
    String password;
    String account;
    int gender;
    String avatar;
    int enable;
    String email;

    @Override
    public void convert(BaseEntity entity) {
        if (entity instanceof User) {
            super.setBaseVo(entity);
            User u = (User) entity;
            this.username = u.getUsername();
            this.password = u.getPassword();
            this.account = u.getAccount();
            this.gender = u.getGender();
            this.avatar = u.getAvatar();
            this.enable = u.getEnable();
            this.email = u.getEmail();
        }

    }
}
