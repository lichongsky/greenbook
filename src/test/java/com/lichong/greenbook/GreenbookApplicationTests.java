package com.lichong.greenbook;

import com.lichong.greenbook.dao.jpa.DemoJpaDao;
import com.lichong.greenbook.entity.Demo;
import com.lichong.greenbook.service.DemoService;
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
}
