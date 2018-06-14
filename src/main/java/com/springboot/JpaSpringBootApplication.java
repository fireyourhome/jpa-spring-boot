package com.springboot;

import com.springboot.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@ServletComponentScan*/
public class JpaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSpringBootApplication.class, args);
    }

    /**
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     * @return
     */
    /*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/look/*");// ServletName默认值为首字母小写，即myServlet
    }*/
}
