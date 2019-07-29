package com.lichong.greenbook.service.impl;

import com.emdata.common.mvc.service.BaseService;
import com.lichong.greenbook.dao.jpa.UserDAO;
import com.lichong.greenbook.entity.User;
import com.lichong.greenbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 15:43
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    UserDAO userDAO;
    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username,password);
    }


}
