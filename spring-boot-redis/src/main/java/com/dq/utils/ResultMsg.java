package com.dq.utils;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/5
 * @Description: TODO
 */
public enum ResultMsg {

    /**
     * 成功
     */
    SUCCESS("200", "SUCCESS"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST("10001", "10001异常"),
    /**
     * 用户密码错误
     */
    USER_PASSWORD_ERROR("10005", "10005异常"),
    /**
     * 失败
     */
    ERROR("100", "ERROR");

    private String code;
    private String msg;

    ResultMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        System.out.println(ResultMsg.SUCCESS.code);
    }
}
