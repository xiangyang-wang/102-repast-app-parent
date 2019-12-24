package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/21 10:01
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopAlbumVo {


    private Long id;

    private Long shopId;

    private String name;

    private String coverPic;

    private Integer picCount;

    private Integer sort;

    private String description;

    private Long albumId;

    private String pic;
}
