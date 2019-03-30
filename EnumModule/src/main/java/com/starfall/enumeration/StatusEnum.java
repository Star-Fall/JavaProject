package com.starfall.enumeration;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration
 * @className: StatusEnum
 * @author: StarFall
 * @date: 2019/3/24 23:45
 * @description: 状态枚举对象
 */
public enum StatusEnum {

    /**
     * 登录状态
     */
    LOGIN(100, "登录") {
        /**
         * 自定义的抽象方法需要在枚举对象中重写
         * @return StatusInfo
         */
        @Override
        public String getStatusInfo() {
            return this.getCode() + ":" + this.getMsg();
        }
    },

    /**
     * 登出状态
     */
    LOGOUT(200, "登出") {
        /**
         * 自定义的抽象方法需要在枚举对象中重写
         * @return StatusInfo
         */
        @Override
        public String getStatusInfo() {
            return this.getCode() + ":" + this.getMsg();
        }
    },

    /**
     * 未知状态
     */
    UNKOWN(300, "未知") {
        /**
         * 自定义的抽象方法需要在枚举对象中重写
         * @return StatusInfo
         */
        @Override
        public String getStatusInfo() {
            return this.getCode() + ":" + this.getMsg();
        }
    };

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

    /**
     * 自定义的抽象方法
     *
     * @return StatusInfo
     */
    public abstract String getStatusInfo();

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}