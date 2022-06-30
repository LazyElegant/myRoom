package com.bobo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }


    @Configuration
    public class MyMvcConfig {

        @Bean
        public WebMvcConfigurer webMvcConfigurer() {
            return new WebMvcConfigurer() {

                //配置跨域
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")     //允许的路径
                            .allowedMethods("*")     //允许的方法
                            .allowedOrigins("*")       //允许的网站
                            .allowedHeaders("*")     //允许的请求头
                            .allowCredentials(true)
                            .maxAge(3600);
                }
            };

        }

    }
}