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
@TableName("comment")
public class Comment {

    /**
     * 评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    @TableField("article_id")
    private Integer articleId;

    /**
     * 上级评论
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 评论用户名
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 评论用户的邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 评论的内容
     */
    @TableField("content")
    private String content;

    /**
     * 评论的时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否显示该评论
     */
    @TableField("show")
    private Boolean show;


}
