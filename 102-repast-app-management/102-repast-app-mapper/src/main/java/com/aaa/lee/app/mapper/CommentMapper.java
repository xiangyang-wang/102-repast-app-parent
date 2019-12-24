package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.Comment;
import com.aaa.lee.app.vo.ShopCommentVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

    List<ShopCommentVo> getCommentInfo(@Param("comment") Comment comment,@Param("pageNum") Long pageNum,@Param("pageSize")Long pageSize);
}