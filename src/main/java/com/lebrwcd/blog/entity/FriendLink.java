package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 友链实体类
 * @Date: Created in 12:00 2020/6/1
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class FriendLink {

    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;

}