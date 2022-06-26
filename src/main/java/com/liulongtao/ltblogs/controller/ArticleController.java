package com.liulongtao.ltblogs.controller;


import com.liulongtao.ltblogs.entity.Article;
import com.liulongtao.ltblogs.service.ArticleService;
import com.liulongtao.ltblogs.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author longtao
 * @since 2022-01-22 11:49:53
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PutMapping("add")
    public ResponseVO addArticle(@RequestBody Article article){
        article.setCreatedTime(new Date());
        article.setUpdateTime(new Date());
        boolean flag = articleService.save(article);
        return flag ? ResponseVO.success("") : ResponseVO.error();
    }

    @GetMapping("{id}")
    public ResponseVO getArticle(@PathVariable("id") Integer id){
        Article article = articleService.getById(id);
        return ResponseVO.success(article);
    }
}

