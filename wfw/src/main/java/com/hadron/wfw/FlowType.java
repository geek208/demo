package com.hadron.wfw;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname FlowType.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public enum FlowType {
	
	//通用0,通用流程 1,自定义扩展2,自选

    NORMAL("0", "通用"), SELFDEFINED("1", "自定义");

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

    private FlowType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}