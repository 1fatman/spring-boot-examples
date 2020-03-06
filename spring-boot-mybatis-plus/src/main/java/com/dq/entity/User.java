package com.dq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/6
 * @Description: TODO
 */
@Data
public class User implements Serializable {
        private int id;
    private String name;
    private int age;
}