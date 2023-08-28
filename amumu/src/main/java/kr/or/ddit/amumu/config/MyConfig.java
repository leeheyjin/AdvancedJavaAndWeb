package kr.or.ddit.amumu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("실행 완?");
        registry.addResourceHandler("/kmerong").addResourceLocations("file:///Users/leehyejin/Project/ddit/upload/amumu");
    }
}
