package com.hadron.wfw;

public enum OwerType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    USER("0", "用户"), ROLE("1", "角色"),ORG("2", "部门"),POSTION("3", "岗位"), OTHERS("4", "其他");

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

    private OwerType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}