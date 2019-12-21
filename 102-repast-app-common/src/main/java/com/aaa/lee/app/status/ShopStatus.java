package com.aaa.lee.app.status;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 15:14
 * @Description
 */
public enum ShopStatus {

    SHOP_HOME("200","店铺首页查询成功"),
    SHOP_DETAILS("201","店铺详情查询成功"),
    SHOP_HOME_FAILED("400","店铺首页查询失败"),
    SHOP_DETAILS_FAILED("401","店铺详情查询失败"),
    SHOP_ALBUM("202","店铺相册查询成功"),
    SHOP_ALBUM_FAILED("402","店铺相册查询失败"),
    SHOP_ALBUM_PIC("202","店铺相册照片查询成功"),
    SHOP_ALBUM_PIC_FAILED("402","店铺相册照片查询失败");


    ShopStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
