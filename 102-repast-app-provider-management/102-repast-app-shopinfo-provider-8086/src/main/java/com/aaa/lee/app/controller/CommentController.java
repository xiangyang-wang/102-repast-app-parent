package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.vo.ShopCommentVo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/23 23:43
 * @Description
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/getCommentInfo")
    public List<ShopCommentVo> getCommentInfo(@RequestParam("shopId")Long shopId, @RequestParam("productId")Long productId, @RequestParam("pageNum")Long pageNum){
        List<ShopCommentVo> commentInfo = commentService.getCommentInfo(shopId, productId, pageNum);
        return commentInfo;
    }
}
