package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.mapper.PostsMapper;
import com.example.smartmedicalsystem.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问诊记录 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {
    @Autowired
    private PostsMapper postsMapper;
    @Override
    public int managerAddPosts(Posts posts){
        return postsMapper.managerAddPosts(posts);
    }
}
