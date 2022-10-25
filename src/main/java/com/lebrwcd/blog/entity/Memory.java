package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName: Menory
 * @Description: 流年记实体类
 * @Author ONESTAR
 * @Date: 2020/10/13 22:37
 * @QQ群：530311074
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
@Data
@ToString
@NoArgsConstructor
public class Memory {

    private Long id;
    private Date createTime;
    private String pictureAddress;
    private String memory;

}
