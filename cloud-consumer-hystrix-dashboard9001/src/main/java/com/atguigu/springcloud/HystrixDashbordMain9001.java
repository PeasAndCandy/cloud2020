package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;


@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixDashbordMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbordMain9001.class,args);
    }

//    @Bean
//    public ServletRegistrationBean getSevlet(){
//        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet);
//        registrationBean.setLoadOnStartup(1);
//        LinkedList<String> url = new LinkedList<String>();
//        url.add("/hystrix.stream");
//        registrationBean.setUrlMappings(url);
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }
}
