package com.petstore.config;

import com.petstore.config.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/repass")
                .excludePathPatterns("/api/register")
                .excludePathPatterns("/api/user/getstore")
                .excludePathPatterns("/api/user/getall")
                .excludePathPatterns("/api/user/getcategory")
                .excludePathPatterns("/api/user/category/getproduct")
                .excludePathPatterns("/api/user/image/product/getimage")
                .excludePathPatterns("/api/user/catrgory/shop/getproducts")
                .excludePathPatterns("/api/user/getone");
    }
}