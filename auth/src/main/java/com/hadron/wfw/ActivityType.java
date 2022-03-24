package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActivityType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public enum ActivityType {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

	START("0", "开始节点"),APPROVER("1", "普通审批节点"), BRANCH("2", "条件分支"),CC("3", "抄送"),END("4", "结束");;

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

    private ActivityType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}