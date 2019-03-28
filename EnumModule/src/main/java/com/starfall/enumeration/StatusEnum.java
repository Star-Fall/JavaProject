package com.starfall.enumeration;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration
 * @className: StatusEnum
 * @author: StarFall
 * @date: 2019/3/24 23:45
 * @description: 状态枚举
 */
public enum StatusEnum {

    /**
     * 登录状态
     */
    LOGIN(100, "登录"),
    /**
     * 登出状态
     */
    LOGOUT(200, "登出"),
    /**
     * 未知状态
     */
    UMKOWN(300, "未知");

    /**
     * 状态代码
     */
    private final Integer code;

    /**
     * 状态信息
     */
    private final String msg;


    /**
     * 自定义的构造函数，传入属性
     *
     * @param code 状态代码
     * @param msg  状态信息
     */
    private StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}