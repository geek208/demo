package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActionType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

public enum ActionType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    AGREE("0", "同意"), REJECTED("1", "否决"),URGE("2", "催办"),HANDOVER("3", "转交");

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

    private ActionType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}