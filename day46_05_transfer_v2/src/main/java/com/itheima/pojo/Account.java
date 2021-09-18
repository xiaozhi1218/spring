package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-11-11  10:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private String name;
    private Integer id;
    private Double money;
}
