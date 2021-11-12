package com.atguigu.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by htk on 2021-11-10.
 * 必须在@ComponentScan注解无法扫描的包下（非主驱动类所在包下）
 */
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//随机轮训
    }
}
