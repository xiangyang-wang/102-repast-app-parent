package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.AlbumMapper;
import com.aaa.lee.app.model.Album;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.ShopAlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/21 10:34
 * @Description
 */
@Service
public class ShopAlbumService extends BaseService<Album> {

    @Value("shop_pic")
    private String shopPic;

    @Autowired
    private AlbumMapper albumMapper;
    @Override
    public Mapper<Album> getMapper() {
        return albumMapper ;
    }
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/21  10:42
     * @Description
     * 根据店铺id查询店铺相册图片
     */
    public List<ShopAlbumVo> getShopAlbumPic(RedisService redisService, Long shopId){
        //先查询redis有没有
        String redisResult = redisService.get(shopPic+shopId);
        //如果有直接返回
        if (!"".equals(redisResult) && null != redisResult){
            return    JSONUtil.toList(redisResult, ShopAlbumVo.class);
        }
        //从数据库中查
        List<ShopAlbumVo> shopAlbumPic = albumMapper.getShopAlbumPic(shopId);

        if (shopAlbumPic.size()>0){
            //如果数据不为空存入redis
            String info = JSONUtil.toJsonString(shopAlbumPic);
            String count = redisService.set(shopPic + shopId, info);
            if ("OK".equals(count.toUpperCase())){

                return shopAlbumPic;
            }

        }
        return null;
    }
}
