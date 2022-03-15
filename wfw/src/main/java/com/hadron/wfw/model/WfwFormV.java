package com.hadron.wfw.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * @classname WfwFormV.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class WfwFormV {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String flowId;
    private List formfield;
    private Date createDate;
    private Date updateDate;
    //付款流水号
   
    private String name;
   
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
    
}
