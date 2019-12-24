package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/23 16:59
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopCommentVo {

    private Long id;

    private Long shopId;

    /**
     * 订单ID
     */

    private Long orderId;

    /**
     * 订单为单一商品时，该字段有值
     */

    private Long productId;

    /**
     * 客户回复名字
     */
    private String memberNickName;


    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */

    private String memberIp;

    /**
     * 客户评论时间
     */
    private Date createTime;


    private Integer showStatus;

    /**
     * 购买时的商品属性
     */

    private String productAttribute;


    private Integer collectCouont;
    /**
     * 评论数量
     */
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */

    private String memberIcon;

    /**
     * 评论数
     */
    private Integer replayCount;
    /**
     * 顾客评论
     */
    private String content;


    /**
     * 商家回复名字
     */
    private String shopMemberNickName;


    /**
     * 商家回复头像
     */
    private String shopMemberIcon;
    /**
     * 商家回复内容
     */
    private String shopContent;
    /**
     * 商家回复名字
     */

    private Date shopCreateTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;


}
