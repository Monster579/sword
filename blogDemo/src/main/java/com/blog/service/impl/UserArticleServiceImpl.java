package com.blog.service.impl;

import com.blog.DAO.mapper.UserArticleMapper;
import com.blog.common.PageUtil.PageHelper;
import com.blog.entity.Comments;
import com.blog.entity.Upvote;
import com.blog.entity.UserArticle;
import com.blog.service.UserArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ASUS on 2019/8/22.
 */
public class UserArticleServiceImpl implements UserArticleService {
    @Autowired
    UserArticleMapper userArticleMapper;

    @Override
    public PageHelper.Page<UserArticle> findAll(UserArticle userArticle, Integer pageNum, Integer pageSize) {
        //分页查询
        System.out.println("第"+pageNum+"页");
        System.out.println("每页显示："+pageSize+"条");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserArticle> list =  userArticleMapper.select(userArticle);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        List<UserArticle> result = endPage.getResult();
        return endPage;

    }


    @Override
    public PageHelper.Page<UserArticle> findAll(UserArticle userArticle, Comments comments, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public PageHelper.Page<UserArticle> findAllByUpvote(UserArticle userArticle, Upvote upvote, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<UserArticle> findByUserId(Integer userId) {
        return null;
    }

    @Override
    public UserArticle findById(Integer id) {
        return null;
    }
}
