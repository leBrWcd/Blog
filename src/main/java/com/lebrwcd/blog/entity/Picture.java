package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 相册实体类
 * @Date: Created in 12:02 2020/6/1
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class Picture implements Serializable {

    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;

}