package com.liulongtao.ltblogs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("friend_site")
public class FriendSite {

    /**
     * 友站id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 友站的名称
     */
    @TableField("name")
    private String name;

    /**
     * 友站的url
     */
    @TableField("url")
    private String url;

    /**
     * 是否显示友站
     */
    @TableField("show")
    private Boolean show;

    /**
     * 友站的图标
     */
    @TableField("img_path")
    private String imgPath;

    /**
     * 友站描述
     */
    @TableField("description")
    private String description;


}
