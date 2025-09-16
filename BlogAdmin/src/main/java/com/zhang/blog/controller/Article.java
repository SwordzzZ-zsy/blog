package com.zhang.blog.controller;

import com.zhang.blog.model.po.ArticlePO;
import com.zhang.blog.model.vo.ArticleVO;
import com.zhang.blog.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class Article {
    @Autowired
    private ArticleService articleService;

    @GetMapping(value={"/","/article/hot"})
    public String showHotArticle(Model model){
       List<ArticlePO> articlePOList= articleService.queryTopArticle();
       //转为VO类型
        List<ArticleVO> articleVOList=BeanUtil.copyToList(articlePOList,ArticleVO.class);
        model.addAttribute("articleList",articleVOList);

        //视图
        return "/blog/articleList";
    }
}
