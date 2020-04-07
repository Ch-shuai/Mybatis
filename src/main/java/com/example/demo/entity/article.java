package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * 2020/4/7
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      帖子实体类
 */

@Data
public class article {

    /**
     *  帖子id
     */
    private int id;
    /**
     * 发帖人
     */
    private String poster;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 发帖内容
     */
    private String content;
    /**
     * 发帖时间
     */
    private String posttime;
    /**
     * 是否置顶
     */
    private String top;

}
