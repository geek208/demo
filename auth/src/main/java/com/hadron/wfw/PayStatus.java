package com.hadron.wfw;

public enum PayStatus {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    UNPAY("0", "未支付"), PAYSUCESS("1", "支付成功"),PAYFAIL("2", "支付失败"),PREREFUND("3", "待退款"), REFUNDED("4", "已退款");

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

    private PayStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}