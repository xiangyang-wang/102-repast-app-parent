package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.ShopInformationMapper;
import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.status.ConsumptionType;
import com.aaa.lee.app.status.ShopStatus;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.ShopAlbumVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 19:00
 * @Description
 */
@Service
public class ShopHomeService extends BaseService<ShopInformation> {

    @Value("shop_details")
    private String shopDetails;
    @Value("shop_home")
    private String shopHome;
    @Autowired
    private ShopInformationMapper shopInformationMapper;
    @Override
    public Mapper<ShopInformation> getMapper() {
        return shopInformationMapper;
    }
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/20  21:13
     * @Description
     * 根据店铺id查询店铺首页
     */
    public List<Object> getShowInfo(RedisService redisService, Long shopId){
        List<Object> resultShopInfo = new ArrayList<>();
        String RedisShowInfo = redisService.get(shopHome + shopId);
        if (!"".equals(RedisShowInfo) && null != RedisShowInfo){

            List<ShopInfoVo> shopInfoVos = JSONUtil.toList(RedisShowInfo, ShopInfoVo.class);
            resultShopInfo.addAll(shopInfoVos);
            resultShopInfo.add(ConsumptionType.SHITANG_TYPE.getMsg());
            resultShopInfo.add(ConsumptionType.SHITANG_TYPE.getCode());
            resultShopInfo.add(ConsumptionType.WAIMAI_TYPE.getMsg());
            resultShopInfo.add(ConsumptionType.WAIMAI_TYPE.getCode());
            resultShopInfo.add(ConsumptionType.PINTUAN_TYPE.getMsg());
            resultShopInfo.add(ConsumptionType.PINTUAN_TYPE.getCode());
            resultShopInfo.add(ConsumptionType.YUYUE_TYPE.getMsg());
            resultShopInfo.add(ConsumptionType.YUYUE_TYPE.getCode());
            return resultShopInfo;
        }

        List<ShopInfoVo> shopInfoByShopId = shopInformationMapper.getShopInfoByShopId(shopId);
        if (shopInfoByShopId.size()>0){
            resultShopInfo.addAll(shopInfoByShopId);
            String redisShopHome = JSONUtil.toJsonString(shopInfoByShopId);
            String count = redisService.set(shopHome + shopId, redisShopHome);
            if ("OK".equals(count.toUpperCase())){
                resultShopInfo.add(ConsumptionType.SHITANG_TYPE.getMsg());
                resultShopInfo.add(ConsumptionType.SHITANG_TYPE.getCode());
                resultShopInfo.add(ConsumptionType.WAIMAI_TYPE.getMsg());
                resultShopInfo.add(ConsumptionType.WAIMAI_TYPE.getCode());
                resultShopInfo.add(ConsumptionType.PINTUAN_TYPE.getMsg());
                resultShopInfo.add(ConsumptionType.PINTUAN_TYPE.getCode());
                resultShopInfo.add(ConsumptionType.YUYUE_TYPE.getMsg());
                resultShopInfo.add(ConsumptionType.YUYUE_TYPE.getCode());
                return resultShopInfo;
            }

        }
        return null;
    }
    /**
     * @Company AAA软件教育
     * @Author  王向阳
     * @Date Create in  2019/12/21  9:31
     * @Description
     * 根据店铺id查询店铺详情
     */
    public ShopInformation getShopInfoDetails(RedisService redisService,Long shopId){
        String redisDetails = redisService.get(shopDetails + shopId);
        if (!"".equals(redisDetails) && null != redisDetails){
            ShopInformation shopInformation = JSONUtil.toObject(redisDetails, ShopInformation.class);
            return shopInformation;
        }

        try {
            ShopInformation shopInfoDetails = super.selectById(shopId);
            String shopInfoDetailsString = JSONUtil.toJsonString(shopInfoDetails);
            if (shopInfoDetails!=null){
                String count = redisService.set(shopDetails + shopId, shopInfoDetailsString);
                if ("OK".equals(count.toUpperCase())){
                    return shopInfoDetails;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
