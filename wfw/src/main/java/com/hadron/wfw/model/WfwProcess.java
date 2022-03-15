package com.hadron.wfw.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwProcess.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Entity
@Table(name = "t_wfw_process")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class WfwProcess {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    //private String pid;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String preActivityId;
    private String currentActivityId;
    private String currentActivityName;
    private String nextActivityId;
    private String nextActivityName;
    
//    private String preUserId;
//    private String currentUserId;
//    private String nextUserId;
    
    
    private String pName;
    private String flowId;
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
    //private int amount;
}
