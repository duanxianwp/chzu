package cn.edu.chzu.collegetalent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther: chzu
 * @date: Created in 2019/2/27 10:50
 * @description:
 */
@Configuration
public class ViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index_body").setViewName("index_body");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/student_add").setViewName("student_add");
        registry.addViewController("/company_add").setViewName("company_add");
        registry.addViewController("/user/add").setViewName("user/add");
        registry.addViewController("/standard/add").setViewName("standard/add");
        registry.addViewController("/pc/my/index").setViewName("my/index");
        registry.addViewController("/qrwindow").setViewName("qrwindow");
        registry.addViewController("/printlist").setViewName("printlist");
        registry.addViewController("/startprint").setViewName("startprint");
        registry.addViewController("/404").setViewName("404");
        registry.addViewController("/500").setViewName("500");
    }

}
