package de.tz.helloweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {
  "de.tz.helloweb"})
public class WebConfig implements WebMvcConfigurer {
     
    @Override
    public void configureDefaultServletHandling(
      DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
  
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = 
          new InternalResourceViewResolver();
        bean.setPrefix("src/main/resources/templates/");
        bean.setSuffix(".html");
        return bean;
    }
}