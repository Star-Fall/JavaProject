package com.starfall.util.date;

/**
 * @project JavaProject
 * @package com.starfall.util.date
 * @className WeekDay
 * @author StarFall
 * @date 2019/4/3 15:16
 * @description 星期枚举对象
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
    private String descCN;

    /**
     * English description
     */
    private String descEN;

    WeekDay(String descCN, String descEN) {
        this.descCN = descCN;
        this.descEN = descEN;
    }

    public String getDescCN() {
        return descCN;
    }

    public String getDescEN() {
        return descEN;
    }
}