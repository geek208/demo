package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActionType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

public enum SalaryType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    IMPORT("0", "手工导入"), QUOTE("1", "数据源获取"),CALCULATE("2", "自定义计算公式");

    private String value;
    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private SalaryType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}