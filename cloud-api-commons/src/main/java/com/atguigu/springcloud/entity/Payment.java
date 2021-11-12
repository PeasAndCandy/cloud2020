package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by htk on 2021/5/11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

  private String id;

  private String serial;
}
