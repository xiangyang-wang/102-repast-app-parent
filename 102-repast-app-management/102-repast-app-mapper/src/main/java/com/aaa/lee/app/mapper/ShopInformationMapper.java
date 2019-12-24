package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.ShopInformation;
import com.aaa.lee.app.vo.ShopInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShopInformationMapper extends Mapper<ShopInformation> {

    List<ShopInfoVo> getShopInfoByShopId(Long id);
}