package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;

import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by htk on 2021-11-10.
 */
@RestController
@Slf4j
public class FeignOrderController {

    @Resource
    private PaymentFeignService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return  paymentService.getPaymentById(id);
    }

    //默认超过一秒访问超时
    @GetMapping("/consumer/payment/feign/timeout")
    public String timeout(){
        return paymentService.timeout();
    }
}
