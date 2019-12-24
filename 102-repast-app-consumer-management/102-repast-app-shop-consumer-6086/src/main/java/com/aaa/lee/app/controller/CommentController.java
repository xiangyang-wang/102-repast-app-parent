package com.aaa.lee.app.controller;

import com.aaa.lee.app.api.IShopHomeService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.vo.ShopCommentVo;
import io.swagger.annotations.Api;
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

@Api(value = "查询评论" ,tags = "查看评论接口")
@RestController
public class CommentController extends BaseController {

    @Autowired
    private IShopHomeService iShopHomeService;
    @PostMapping("/getCommentInfo")
    public ResultData getCommentInfo(String token, @RequestParam("shopId")Long shopId, @RequestParam("productId")Long productId, @RequestParam("pageNum")Long pageNum){
        if (token==null){
            return getTokenFailed();
        }
        List<ShopCommentVo> commentInfo = iShopHomeService.getCommentInfo(shopId, productId, pageNum);
        if (0<commentInfo.size()){
            return   getCommentSuccess(commentInfo);
        }
        return getCommentFailed();
    }
    }
