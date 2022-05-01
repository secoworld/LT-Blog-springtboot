package com.liulongtao.ltblogs.mapper;

import com.liulongtao.ltblogs.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longtao
 * @since 2022-01-22 11:49:53
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}