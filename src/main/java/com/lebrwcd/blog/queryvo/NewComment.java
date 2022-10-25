package com.lebrwcd.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 最新评论实体类
 * @Date: Created in 19:45 2020/8/19
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class NewComment {

    private Long id;
    private Long blogId;
    private String title;
    private String content;


}