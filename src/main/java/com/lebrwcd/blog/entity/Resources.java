package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 资源库实体类
 * @Date: Created in 14:33 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class Resources {

    private Long id;
    private String resourceName;
    private String firstType;
    private String secondType;
    private String pictureAddress;
    private String resourceAddress;
    private String resourceDescription;
    private Date createTime;
    private Integer sort;
    private boolean published;
}