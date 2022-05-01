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
@TableName("category")
public class Category {

    /**
     * 分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类名
     */
    @TableField("name")
    private String name;

    /**
     * 分类描述
     */
    @TableField("description")
    private String description;


}
