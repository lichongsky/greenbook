package com.lichong.greenbook.controller;

import com.emdata.common.mvc.controller.AbstractController;
import com.lichong.greenbook.entity.Result;
import com.lichong.greenbook.entity.User;
import com.lichong.greenbook.service.UserService;
import com.lichong.greenbook.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/29 14:40
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController extends AbstractController<User, UserVo> {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {

        // 对 html 标签进行转义，防止 XSS 攻击
        String userName = requestUser.getUsername();
        User user = userService.findByUsernameAndPassword(userName, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/registry")
    public Result registry(@RequestBody User requestUser) {
        String userName = requestUser.getUsername();
        User user = userService.findByUsername(userName);
        if (user != null) {
            return new Result(400);
        } else {
            userService.save(requestUser);
            return new Result(200);
        }

    }


}
