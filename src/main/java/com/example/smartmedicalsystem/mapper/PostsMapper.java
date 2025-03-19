package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问诊记录 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface PostsMapper extends BaseMapper<Posts> {
    int managerAddPosts(Posts posts);
    boolean updatePosts (Posts posts);
}
