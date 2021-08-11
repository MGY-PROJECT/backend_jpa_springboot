package knut.circle.config;

import knut.circle.Filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter(){
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>(new LoginFilter());
        bean.addUrlPatterns("/**"); //모든 url에 대해서 필터를 허용하라
        bean.setOrder(0); //숫자가 낮을 수록 우선순위가 높아서 먼저 실행됨
        return bean;
    }
}
