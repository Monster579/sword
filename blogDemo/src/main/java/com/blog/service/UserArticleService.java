package com.blog.service;

import com.blog.common.PageUtil.PageHelper;
import com.blog.entity.Comments;
import com.blog.entity.Upvote;
import com.blog.entity.UserArticle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by ASUS on 2019/8/22.
 */
public interface UserArticleService {

    /**
     * 分页查找所有文章
     * @param userArticle
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<UserArticle> findAll(UserArticle userArticle, Integer pageNum, Integer pageSize);

    PageHelper.Page<UserArticle> findAll(UserArticle userArticle, Comments comments, Integer pageNum, Integer pageSize);
    PageHelper.Page<UserArticle> findAllByUpvote(UserArticle userArticle, Upvote upvote, Integer pageNum, Integer pageSize);

    /**
     * 根据用户id查找所有文章
     */
    List<UserArticle> findByUserId(Integer userId);


    /**
     * 根据id 查找文章
     */
    UserArticle findById(Integer id);

}
