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
    SUNDAY("星期日", "Sunday"),
    /**
     * 星期一
     */
    MONDAY("星期一", "Monday"),
    /**
     * 星期二
     */
    TUESDAY("星期二", "Tuesday"),
    /**
     * 星期三
     */
    WEDNESDAY("星期三", "Wednesday"),
    /**
     * 星期四
     */
    THURSDAY("星期四", "Thursday"),
    /**
     * 星期五
     */
    FRIDAY("星期五", "Friday"),
    /**
     * 星期六
     */
    SATURDAY("星期六", "Saturday");

    /**
     * 中文描述
     */
    private String desc_CN;

    /**
     * Englis description
     */
    private String desc_EN;

    WeekDay(String desc_CN, String desc_EN) {
        this.desc_CN = desc_CN;
        this.desc_EN = desc_EN;
    }

    public String getDesc_CN() {
        return desc_CN;
    }

    public String getDesc_EN() {
        return desc_EN;
    }
}
