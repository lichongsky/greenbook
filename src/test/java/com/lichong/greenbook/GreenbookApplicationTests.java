package com.lichong.greenbook;

import com.emdata.common.hibernate.UUIDSequence;
import com.lichong.greenbook.entity.Demo;
import com.lichong.greenbook.entity.User;
import com.lichong.greenbook.service.DemoService;
import com.lichong.greenbook.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreenbookApplicationTests {

    @Autowired
    DemoService demoService;

    @Autowired
    UserService userService;

    @Test
    public void addDemo() {
        Demo demo = new Demo();
        demo.setName("yaoming");
        demo.setAddress("shanghai");
//        demo.setCreateTime(new Date());
//        demo.setUpdateTime(new Date());
        Demo save = demoService.save(demo);
        System.out.println(save);
    }


    @Test
    public void saveOrUpdateDemo() {
        Demo demo = new Demo();
        demo.setId("6Lv32Qe6LE00LFJ3JWB");
        demo.setName("yaoming1222222");
        demo.setAddress("shanghai");
        Demo save = demoService.update(demo);
        System.out.println(save);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setAccount("McGrady");
        user.setAvatar("http://www.uuwtq.com/file/image/tx/4w1090506616u3665408704t26.jpg");
        user.setEmail("lichongsky@qq.com");
        user.setEnable(1);
        user.setGender(1);
        user.setUsername("McGrady");
        user.setPassword("123456");
        user.setRegTime(new Date());
        userService.save(user);
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("kobe");
        System.out.println(user.getId());
    }

    @Test
    public void getUUId() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUIDSequence.uuid();
            System.out.println(uuid);
        }
    }

}
