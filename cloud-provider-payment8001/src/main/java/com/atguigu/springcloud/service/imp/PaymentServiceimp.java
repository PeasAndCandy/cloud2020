package com.atguigu.springcloud.service.imp;


import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by htk on 2021/5/11.
 */
@Service
public class PaymentServiceimp implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public Payment getPaymentById(String id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public int updatePaymentById(Payment payment) {
        return paymentMapper.updatePaymentById(payment);
    }

    @Override
    public int delPaymentById(String id) {
        return paymentMapper.delPaymentById(id);
    }
}
