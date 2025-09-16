package com.zhang.blog.service.impl;

import com.zhang.blog.mapper.ArticleMapper;
import com.zhang.blog.model.po.ArticlePO;
import com.zhang.blog.service.ArticleService;
import com.zhang.blog.settings.ArticleSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleSettings articleSettings;

    @Override
    public List<ArticlePO> queryTopArticle() {
        Integer lowRead=articleSettings.getLowRead();
        Integer topRead=articleSettings.getTopRead();
        articleMapper.selectByArticleId(lowRead,topRead);
        return articleMapper.selectByArticleId(lowRead,topRead);
    }
}
