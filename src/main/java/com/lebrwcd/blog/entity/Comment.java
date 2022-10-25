package com.lebrwcd.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 评论实体类
 * @Date: Created in 11:12 2020/6/1
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long blogId;
    private Long parentCommentId;
    private boolean adminComment;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private String parentNickname;


}