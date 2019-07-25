package com.lichong.greenbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置Swagger2
 *
 * @author : zhangxin
 * @version : 1.0
 * @since : 2018/09/01
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     *
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.lichong.whitebook.controller")).paths(PathSelectors.any()).build();
    }

    /**
     * api文档的详细信息函数,注意这里的注解引用的是哪个
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // //大标题
                .title("datacheck-service RESTful API")
                // 版本号
                .version("0.0.1-SNAPSHOT")
                // .termsOfServiceUrl("NO terms of service")
                // 描述
                .description("API 描述")
                // 作者
                // .contact(new Contact("cashZhang", "https://blog.csdn.net/m0_37726449", "cashzhang27@qq.com"))
                // .license("The Apache License, Version 2.0")
                // .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}

