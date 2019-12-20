package com.aaa.lee.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "sms_advertise_position")
public class AdvertisePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务类型，餐饮小程序0
     */
    private Integer type;

    /**
     * 广告位置名称
     */
    private String name;

    /**
     * 广告位置名称
     */
    private String descrition;

    /**
     * 该位置最多几个广告
     */
    @Column(name = "max_count")
    private Integer maxCount;


}