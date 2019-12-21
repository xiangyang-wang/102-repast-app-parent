package com.aaa.lee.app.status;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 14:17
 * @Description
 */
public  enum  ConsumptionType {


    WAIMAI_TYPE("0","外卖"),
    SHITANG_TYPE("1","食堂点餐"),
    YUYUE_TYPE("2","预约点餐"),
    DIANPU_PINGJIA("2","预约点餐"),
    PINTUAN_TYPE("3","拼团点餐");


    ConsumptionType(String msg, String code){
        this.code=code;
        this.msg=msg;
    }
   private String msg;
   private String code;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
