package com.lichong.greenbook.dao.jpa;

import com.emdata.common.mvc.dao.BaseRepository;
import com.lichong.greenbook.entity.User;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 15:41
 */
public interface UserDAO extends BaseRepository<User> {

    User findByUsername(String uerName);

    User getByUsernameAndPassword(String userName, String passWord);

}
