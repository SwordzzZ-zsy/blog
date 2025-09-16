package com.zhang.blog.mapper;

import com.zhang.blog.model.po.ArticlePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    //查询首页的文章列表
    @Select("""
        select id, user_id, title, summary, read_count, create_time, update_time from
            article where read_count>= #{lowRead}
            order by read_count desc
            limit #{topRead}
        """)
    List<ArticlePO> selectByArticleId(@Param("lowRead") Integer lowRead, @Param("topRead")Integer topRead);
}
