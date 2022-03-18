package com.hadron.wfw.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwForm.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Entity
@Builder
@Table(name = "t_wfw_action")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class WfwAction extends BaseEntity implements Serializable{
//    @Id
//    @GeneratedValue
//    private long id;
    //订单流水号
    private String activityId;
    private Date createDate;
    private Date updateDate;
    //付款流水号
       private String name;
   
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
    
}
