package com.manulife.hk.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // 自定义 OpenAPI 文档信息
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3.x API 文档") // 文档标题
                        .version("1.0.0") // 接口版本
                        .description("基于 SpringDoc OpenAPI 生成的 RESTful API 文档") // 文档描述
                        .termsOfService("https://example.com/terms") // 服务条款（可选）
                        .contact(new io.swagger.v3.oas.models.info.Contact() // 作者信息（可选）
                                .name("开发者")
                                .email("dev@example.com")));
    }
}
