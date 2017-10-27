package com.smx.mapper;

import com.smx.model.BlogModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogModel record);

    int insertSelective(BlogModel record);

    BlogModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogModel record);

    int updateByPrimaryKey(BlogModel record);

    List<BlogModel> getBlogs(@Param("createBy") String createBy);
}