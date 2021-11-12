package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entity.Payment;

/**
 * Created by htk on 2021/5/11.
 */
public interface PaymentService {

    Payment getPaymentById(String id);

    int create(Payment payment);

    int updatePaymentById(Payment payment);

    int delPaymentById(String id);
}
