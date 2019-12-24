package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.model.Comment;
import com.aaa.lee.app.page.PageInfos;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.vo.ShopCommentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/23 22:32
 * @Description
 */
@Service
public class CommentService extends BaseService<Comment> {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }


    public List<ShopCommentVo> getCommentInfo(Long shopId,Long productId,Long pageNum)  {
        Comment comment = new Comment();
        comment.setShopId(shopId);
        comment.setProductId(productId);
        List<ShopCommentVo> commentInfo = commentMapper.getCommentInfo(comment,pageNum, StaticProperties.COMMENTPAGESIZE);
        if (commentInfo.size()>0){
            return commentInfo;
        }
        return null;

    }
}
