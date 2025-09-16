package com.zhang.blog.service;

import com.zhang.blog.model.po.ArticlePO;

import java.util.List;

public interface ArticleService {

    List<ArticlePO> queryTopArticle();
}
