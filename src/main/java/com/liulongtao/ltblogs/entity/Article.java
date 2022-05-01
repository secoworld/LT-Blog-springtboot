package com.liulongtao.ltblogs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author longtao
 * @since 2022-01-22 11:49:53
 */
@Getter
@Setter
@TableName("article")
public class Article {

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    @TableField("title")
    private String title;

    /**
     * 标题图片地址
     */
    @TableField("title_img_path")
    private String titleImgPath;

    /**
     * 作者
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 文章内容
     */
    @TableField("content")
    private String content;

    /**
     * 是否显示该文章
     */
    @TableField("show")
    private Boolean show;

    /**
     * 是否为草稿
     */
    @TableField("draft")
    private Boolean draft;

    /**
     * 文章创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 文章修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否默认显示该文章的评论
     */
    @TableField("show_comment")
    private Boolean showComment;


}
