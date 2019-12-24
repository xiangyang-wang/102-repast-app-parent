package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:05
 * @Description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopInfoVo implements Serializable {

    private String name;
    private String province;
    private String city;
    private String borough;
    private String lng;

    private String lat;
    private String phone;
    private Long facilityId;
    private Date authStartTime;
    private Byte status;

    private String images;
    private String openTime;
    private Byte closed;
    private String address;
    private Long shopId;

    private String title;
    private String description;
    private String icon;

}
