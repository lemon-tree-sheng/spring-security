package com.sheng.security.config;

import com.sheng.security.web.filter.TimeFilter;
import com.sheng.security.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengxingyue on 2017/10/19.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private TimeInterceptor timeInterceptor;

    // spring boot 对于异步的配置支持
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerCallableInterceptors()
//        configurer.registerDeferredResultInterceptors()
//        configurer.setDefaultTimeout()
//        configurer.setTaskExecutor()
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
