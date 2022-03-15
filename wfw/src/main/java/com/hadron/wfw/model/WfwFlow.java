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
 * @classname WfwFlow.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Entity
@Table(name = "t_wfw_flow")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class WfwFlow {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
   // private String orderSn;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String cpyId;
    private String fname;

    
    private String userId;
    //0 通用 1-自定义
    private String flowType;
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
   // private int amount;;
}
