package com.aaa.lee.app.controller;

import com.aaa.lee.app.api.IShopHomeService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.status.ConsumptionType;
import com.aaa.lee.app.vo.ShopAlbumVo;
import com.aaa.lee.app.vo.ShopCommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 21:45
 * @Description
 */
@RestController
@Api(value = "店铺首页信息" ,tags = "店铺首页信息接口")
public class ShopController extends BaseController {

    @Autowired
    private IShopHomeService iShopHomeService;

    @GetMapping("/shopHome")
    @ApiOperation(value = "商品首页" ,notes = "查询商品首页信息")
    public ResultData getShopHome(String token, @RequestParam("shopId") Long shopId){
        if (token==null){
            return getTokenFailed();
        }
        List<Object> shopHome = iShopHomeService.getShopHome(shopId);
        if (shopHome.size()>0){
            return shopHomeSuccess(shopHome);
        }else {

            return shopHomeFailed();
        }

    }
    @GetMapping("/shopInfoDetails")
    @ApiOperation(value = "店铺详情" ,notes = "店铺详情信息")
    public ResultData getShopInfoDetails(String token,@RequestParam("shopId") Long shopId){
        if (token==null){
            return getTokenFailed();
        }

        ShopInformation shopInfoDetails = iShopHomeService.getShopInfoDetails(shopId);
        if (null!=shopInfoDetails){
            return shopDetailsSuccess(shopInfoDetails);
        }
        return shopDetailsFailed();
    }
    @GetMapping("/shopAlbumPic")
    @ApiOperation(value = "店铺相册" ,notes = "店铺相册图片")
    public ResultData getShopAlbumPic(String token,@RequestParam("shopId") Long shopId){
        if (token==null){
            return getTokenFailed();
        }
        List<ShopAlbumVo> shopAlbumPic = iShopHomeService.getShopAlbumPic(shopId);
        if (shopAlbumPic.size()>0){
            return shopAlbumSuccess(shopAlbumPic);
        }
        return shopAlbumFailed();
    }



}
