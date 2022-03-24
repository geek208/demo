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
 * @classname WfwFormField.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */


@Entity
@Table(name = "t_wfw_form_field")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class WfwFormField {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String flowId;
    //private String flowId;
    private String userId;
    private String parentId;
    private String rules;
    private String pId;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String formId;
    private String name;
    private String cnName;
    private String fieldType;
    private String fieldvalue;
     //未支付 0,支付成功 1,支付失败 2,待退款 3,已退款 4
    private int status;
    //private int amount;;
}
