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
 * @classname EasyPay.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Entity
@Table(name = "t_easy_pay")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EasyPay {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String orderSn;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String paySn;
    private String name;
    private String sku;
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
    private int amount;;
}
