package com.atguigu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//全局default,该类下的所有方法调用同一个服务降级方法
@DefaultProperties(defaultFallback = "paymentGlobalFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
})
public class OrderController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return service.paymentInfo_OK(id);
    }

    // 设置超过 6秒采用服务降级
    // 先设置feign的超时时间
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "6500")
    })
//    @HystrixCommand
    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
        return service.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "80异常，降级处理";
    }

    // 下面是全局 fallback
    public String paymentGlobalFallBack(){
        return "80：获取异常，调用方法为全局fallback";
    }
}
