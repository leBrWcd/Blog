package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 留言实体类
 * @Date: Created in 11:44 2020/6/1
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class Message {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    //回复留言
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;

    private String parentEmail;

    public String getParentEmail() {
        return parentEmail;
    }

    public String setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
        return parentEmail;
    }

}