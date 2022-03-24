package com.hadron.wfw.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwActivity.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */


@Entity
@Table(name = "t_wfw_activity")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class WfwActivity {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
   // private String orderSn;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String flowId;
    //规则字段rules,暂时支持一条规则
    private String fieldId;
    private String rules;
//    
//    private String fieldId1;
//    private String fieldId2;
    private String name;
    
    //操作
    private String action1;
    private String action2;
    private String action3;
    
    //前序活动
    private String preActivity;
    //后续活动,分叉多个后续 不适用，采用link
    private String nextActivity;
    
    //审批者类型  0-用户， 1-角色   2-部门   3-发起人自选 4-岗位 5- 角色
    private String userType;
    //审批类型 0-或签 1- 会签  2-依次审批
    private String approveType;
    //节点类型 0-开始  1-普通审批   2--条件分叉  3-CC 节点  4- 结束节点  
    private String activtiyType;
    
    private String userId;
    //private String action1;
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
   // private int amount;;
}
