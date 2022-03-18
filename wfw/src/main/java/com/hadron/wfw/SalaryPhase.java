package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActionType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

public enum SalaryPhase {
	
	//未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4

    SELECT("0", "选择计薪人员"), BRFORETAX("1", "税前算薪"),AFTERTAX("2", "税后算薪"),FINISH("3", "算薪完成");

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

    private SalaryPhase(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}