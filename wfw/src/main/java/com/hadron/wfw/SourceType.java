package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActionType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

public enum SourceType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    BASE("0", "薪资档案"), ATTENDANCE("1", "考勤"),SOCIALSECURITY("2", "社保数据"),TAX("2", "个税数据"),DEDUCT("2", "专项扣除");

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

    private SourceType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}