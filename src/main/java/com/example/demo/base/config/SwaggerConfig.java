package com.example.demo.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 10:02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 文档主体信息
                .apiInfo(apiInfo())
                .groupName("api")
                // 接口选择器
                .select()
                // 告诉springfox哪些接口要生成swagger文档(扫描该包下的API注解)
                // 如果某个接口不想暴露,可以使用以下注解
                // @ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                // 设置哪些接口生成在swagger文档上（any()——所有controller下的接口）
                .paths(PathSelectors.any())
                .build()
                // 添加token登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }


    /**
     * 文档主体信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // API文档标题
                .title("Demo")
                // 描述
                .description("本文档demo调用。")
                // 版本
                .version("v1.0")
                // 作者信息
                .contact(new Contact("广东DyyHome有限公司", "https://www.dyyhome.com", "t08069a@163.com"))
                .build();
    }


    private List<ApiKey> securitySchemes() {
        // 设置请求头信息
        List<ApiKey> apiKeyList= new ArrayList<>();
        // Authorization
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.any())
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}
