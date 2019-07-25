package com.lichong.greenbook;

import com.emdata.common.handler.exception.MyExceptionHandler;
import com.emdata.common.handler.interceptor.WebMvcInterceptorRegistry;
import com.emdata.common.mvc.dao.BaseRepositoryFactoryBean;
import com.emdata.common.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@SpringBootApplication
@ComponentScan(basePackages = {"com.emdata.common", "com.lichong.greenbook"})
@EnableJpaAuditing // 开启jpa支持
@Import(value = {MyExceptionHandler.class, SpringUtil.class, WebMvcInterceptorRegistry.class})
public class GreenbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenbookApplication.class, args);
    }

}
