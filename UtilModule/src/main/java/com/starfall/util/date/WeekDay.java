package com.starfall.util.date;

/**
 * @project： JavaProject
 * @package： com.starfall.util.date
 * @className： WeekDay
 * @author： StarFall
 * @date： 2019/4/3 15:16
 * @description： 星期枚举对象
 */
public enum WeekDay {

    /**
     * 星期日
     */
    SUNDAY("星期日"),
    /**
     * 星期一
     */
    MONDAY("星期一"),
    /**
     * 星期二
     */
    TUESDAY("星期二"),
    /**
     * 星期三
     */
    WEDNESDAY("星期三"),
    /**
     * 星期四
     */
    THURSDAY("星期四"),
    /**
     * 星期五
     */
    FRIDAY("星期五"),
    /**
     * 星期六
     */
    SATURDAY("星期六");

    /**
     * 描述
     */
    private String desc;

    WeekDay(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
