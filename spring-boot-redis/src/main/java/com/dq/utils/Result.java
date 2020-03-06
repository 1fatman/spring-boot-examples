package com.dq.utils;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/5
 * @Description: TODO
 */
public class Result<T> {
    private String message;
    private String code;
    private T data;

    private Result(T data) {
        this.code = ResultMsg.SUCCESS.getCode();
        this.message = ResultMsg.SUCCESS.getMsg();
        this.data = data;
    }

    private Result(ResultMsg rm) {
        if (rm == null) {
            return;
        }
        this.code = ResultMsg.ERROR.getCode();
        this.message = ResultMsg.ERROR.getMsg();
    }

    /**
     * 成功时候的调用
     *
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success() {
        return (Result<T>) success("");
    }

    /**
     * 失败时候的调用
     *
     * @return
     */
    public static <T> Result<T> error(ResultMsg rm) {
        return new Result<T>(rm);
    }

    /**
     * 失败时候的调用,扩展消息参数
     *
     * @param rm
     * @param msg
     * @return
     */
    public static <T> Result<T> error(ResultMsg rm, String msg) {
        rm.setMsg(rm.getMsg() + "--" + msg);
        return new Result<T>(rm);
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}
