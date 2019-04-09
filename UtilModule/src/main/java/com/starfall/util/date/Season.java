package com.starfall.util.date;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.util.date
 * @className Season
 * @date 2019/4/9 10:04
 * @description 季度枚举对象
 */
public enum Season {

    /**
     * 春季（第一季度）
     */
    SPRING("春季", "spring"),
    /**
     * 夏季（第二季度）
     */
    SUMMER("夏季", "summer"),
    /**
     * 秋季（第三季度）
     */
    AUTUMN("秋季", "autumn"),
    /**
     * 冬季（第四季度）
     */
    WINTER("冬季", "winter");

    /**
     * 中文描述
     */
    private String descCN;

    /**
     * English description
     */
    private String descEN;

    Season(String descCN, String descEN) {
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