package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by htk on 2021/5/11.
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+payment);
        // 判断是否插入成功
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") String id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****查询结果："+paymentById);
        // 判断是否查询成功
        if (paymentById != null){
            return new CommonResult(200,"查询成功！端口：" + serverPort,paymentById);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }
    @PutMapping("/payment/update")
    public CommonResult<Payment> update(@RequestBody Payment payment){
        int result = paymentService.updatePaymentById(payment);
        log.info("*****更新结果："+payment);
        // 判断是否查询成功
        if (result > 0){
            return new CommonResult(200,"更新成功！",result);
        }else {
            return new CommonResult(444,"更新失败",null);
        }
    }
    @DeleteMapping("/payment/del/{id}")
    public CommonResult<Payment> delete(@PathVariable("id") String id){
        int result = paymentService.delPaymentById(id);
        log.info("*****删除结果：成功！");
        // 判断是否查询成功
        if (result > 0){
            return new CommonResult(200,"删除成功！","id:" + id);
        }else {
            return new CommonResult(444,"删除失败",null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
