package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by htk on 2021/5/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer Code;
    private String mssage;
    private T data;

    public CommonResult(Integer code, String mssage){
        this(code,mssage,null);
    }
}
