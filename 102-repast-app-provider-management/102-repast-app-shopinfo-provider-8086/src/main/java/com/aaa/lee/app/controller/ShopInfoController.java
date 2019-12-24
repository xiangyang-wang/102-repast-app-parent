package com.aaa.lee.app.controller;

import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.service.RedisService;
import com.aaa.lee.app.service.ShopAlbumService;
import com.aaa.lee.app.service.ShopHomeService;
import com.aaa.lee.app.vo.ShopAlbumVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/21 1:57
 * @Description
 */
@RestController
public class ShopInfoController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private ShopAlbumService shopAlbumService;
    @Autowired
    private ShopHomeService shopHomeService;
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/21  9:39
     * @Description
     * 根据商品id查询首页
     */
    @GetMapping("/shopHome")
    public List<Object> getShopHome( @RequestParam("shopId") Long shopId){
        List<Object> showInfo = shopHomeService.getShowInfo(redisService, shopId);
        return showInfo;
    }
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/21  9:40
     * @Description
     * 根据店铺id查询店铺详情
     */
    @GetMapping("/shopInfoDetails")
    public ShopInformation getShopInfoDetails(@RequestParam("shopId") Long shopId){
        return   shopHomeService.getShopInfoDetails(redisService,shopId);
    }
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/21  11:00
     * @Description
     * 根据店铺id查询相册
     */
    @GetMapping("/shopAlbumPic")
    public List<ShopAlbumVo> getShopAlbumPic(@RequestParam("shopId") Long shopId){
       return shopAlbumService.getShopAlbumPic(redisService,shopId);
    }
}
