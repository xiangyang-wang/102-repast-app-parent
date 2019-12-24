package com.aaa.lee.app.api;

import com.aaa.lee.app.fallback.ShopHomeFallback;
import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.vo.ShopAlbumVo;
import com.aaa.lee.app.vo.ShopCommentVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 22:19
 * @Description
 */
@FeignClient(value = "shopinfo-interface-provider",fallbackFactory = ShopHomeFallback.class)
public interface IShopHomeService {

    @GetMapping("/shopHome")
    List<Object> getShopHome(@RequestParam("shopId") Long shopId);

    @GetMapping("/shopInfoDetails")
    ShopInformation getShopInfoDetails(@RequestParam("shopId") Long shopId);

    @GetMapping("/shopAlbumPic")
     List<ShopAlbumVo> getShopAlbumPic(@RequestParam("shopId") Long shopId);

    @PostMapping("/getCommentInfo")
     List<ShopCommentVo> getCommentInfo(@RequestParam("shopId")Long shopId, @RequestParam("productId")Long productId, @RequestParam("pageNum")Long pageNum);


    }
