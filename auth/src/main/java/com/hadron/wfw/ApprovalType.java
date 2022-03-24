package com.hadron.wfw;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ApprovalType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public enum ApprovalType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    OR("0", "或签"), AND("1", "会签"),SQE("2", "依次审批");

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

    private ApprovalType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}