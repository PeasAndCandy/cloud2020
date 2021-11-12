package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by htk on 2021/5/11.
 */
@Mapper
public interface PaymentMapper {

    Payment getPaymentById(@Param("id") String id);

    int create(Payment payment);

    int updatePaymentById(Payment payment);

    int delPaymentById(@Param("id") String id);
}
