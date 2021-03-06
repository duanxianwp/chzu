package cn.edu.chzu.collegetalent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SecurityHandlerInterceptor())
                //.addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("myplugs.js/**","css/**","res/**","skin.default/**","js/**"))
                .excludePathPatterns(Arrays.asList("/myplugs.js/**","/css/**","/res/**","/skin.default/**","/js/**"))
                .excludePathPatterns("/error")
                .excludePathPatterns("/keepalived")
                .excludePathPatterns("/login.do")
                .excludePathPatterns("/admin/login.do")
                .excludePathPatterns("/questionnaire/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/upload")
                .excludePathPatterns(Arrays.asList("/students/register.do","/students/get","/students/update","/students/updatePassword"))
                .excludePathPatterns(Arrays.asList("/company/register.do","/company/get","/company/update","/company/updatePassword"))
                .excludePathPatterns(Arrays.asList("/questionnaire/list","/questionnaire/get","/questionnaire/listWithSubject","/questionnaire/addWithSubjest"));
    }

}
