package com.aaa.lee.app.status;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 15:14
 * @Description
 */
public enum CommentStatus {

    COMMENT_SESSION("200","获取评论成功"),
    COMMENT_FAILED("400","获取评论失败");


    CommentStatus(String code, String msg) {
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
