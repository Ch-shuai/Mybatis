package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 *
 * @Description
 *      Swagger配置文件
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * RequestHandlerSelectors.basePackage(“com.example.demo.controller”)，这是扫描注解的配置，即你的API接口位置。
     */
    @Bean
    @Profile({"dev","test"})
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //详细制定
                .apiInfo(apiInfo())
                .select()
                //扫描指定下面的包
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("后台文档接口")
                .version("1.0")
                .build();
    }
}
