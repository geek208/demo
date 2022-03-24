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
 * @classname WfwTask.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Entity
@Table(name = "t_wfw_task")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class WfwTask {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String taskName;
    private Date createDate;
    private Date updateDate;
    //付款流水号
    private String pid;
    private String userId;
    private String flowId;
    //当前处理节点
    private String currentId;
    //审批意见
    private String comments;

    private int status;
    //private int amount;;
}
