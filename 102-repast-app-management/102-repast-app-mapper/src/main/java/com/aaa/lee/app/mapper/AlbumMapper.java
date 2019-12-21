package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.Album;
import com.aaa.lee.app.vo.ShopAlbumVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {

   List<ShopAlbumVo>  getShopAlbumPic(Long shopId);
}