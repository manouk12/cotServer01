package com.example.cotServer01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //WebMvcConfigurer 구현으로 CORS설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //모든 URL에 CORS허용
                .allowedOrigins("*")        //모든 origin(도메인) 허용
                .allowedMethods("GET","POST","PUT","DELETE")    //허용할 메소드
                .allowedHeaders("*")    //모든 요청 헤더 허용
                .allowCredentials(false);   //쿠키, 인증정보포함여부(true이면 allowedOrigins에 *사용 불가)
    }
}
