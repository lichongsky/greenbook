package com.lichong.greenbook.service;

import com.emdata.common.mvc.service.IBaseService;
import com.lichong.greenbook.entity.User;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 15:43
 */
public interface UserService extends IBaseService<User> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);

}
