package com.aaa.lee.app.fallback;


import com.aaa.lee.app.api.IShopHomeService;
import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.vo.ShopAlbumVo;
import com.aaa.lee.app.vo.ShopCommentVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/19 14:57
 * @Description
 **/
@Component
public class ShopHomeFallback implements FallbackFactory<IShopHomeService> {


    @Override
    public IShopHomeService create(Throwable throwable) {
        IShopHomeService shopHomeService = new IShopHomeService(){

            @Override
            public List<Object> getShopHome(Long shopId) {
                System.out.println("商家首页信息");
                return null;
            }

            @Override
            public ShopInformation getShopInfoDetails(Long shopId) {
                System.out.println("商家详情");
                return null;
            }

            @Override
            public List<ShopAlbumVo> getShopAlbumPic(Long shopId) {
                System.out.println("店家图片");
                return null;
            }

            @Override
            public List<ShopCommentVo> getCommentInfo(Long shopId, Long productId, Long pageNum) {
                return null;
            }
        };
        return null;
    }
}
