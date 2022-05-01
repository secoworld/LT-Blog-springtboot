package com.liulongtao.ltblogs.serviceImpl;

import com.liulongtao.ltblogs.entity.Tags;
import com.liulongtao.ltblogs.mapper.TagsMapper;
import com.liulongtao.ltblogs.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longtao
 * @since 2022-01-22 11:49:53
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

}
