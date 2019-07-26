package com.lichong.greenbook.service;

import com.lichong.greenbook.entity.User;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 15:43
 */
public interface UserService {

    User findByName(String name);
}
