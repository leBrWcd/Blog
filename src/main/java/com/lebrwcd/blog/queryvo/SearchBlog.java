package com.lebrwcd.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 搜索博客管理列表
 * @Date: Created in 14:16 2020/6/8
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
@ToString
@NoArgsConstructor
public class SearchBlog {

    private String title;
    private Long typeId;

}