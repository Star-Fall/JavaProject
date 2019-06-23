package com.starfall.util.date;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.util.date
 * @className Month
 * @date 2019/4/9 15:52
 * @description Month, 月份枚举对象
 */
public enum Month {

	/**
	 * 一月
	 */
	JANUARY("一月", "January"),
	/**
	 * 二月
	 */
	FEBRUARY("二月", "February"),
	/**
	 * 三月
	 */
	MARCH("三月", "March"),
	/**
	 * 四月
	 */
	APRIL("四月", "April"),
	/**
	 * 五月
	 */
	MAY("五月", "May"),
	/**
	 * 六月
	 */
	JUNE("六月", "June"),
	/**
	 * 七月
	 */
	JULY("七月", "July"),
	/**
	 * 八月
	 */
	AUGUST("八月", "August"),
	/**
	 * 九月
	 */
	SEPTEMBER("九月", "September"),
	/**
	 * 十月
	 */
	OCTOBER("十月", "October"),
	/**
	 * 十一月
	 */
	NOVEMBER("十一月", "November"),
	/**
	 * 十二月
	 */
	DECEMBER("十二月", "December");

	/**
	 * 中文描述
	 */
	private String descCN;

	/**
	 * English description
	 */
	private String descEN;

	Month(String descCN, String descEN) {
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