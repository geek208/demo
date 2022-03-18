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
 * 
 * 
 * @author xuychao xuychao@163.com
 *
 */

@Entity
@Table(name = "t_salary_item")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SalaryItem {
    @Id
    @GeneratedValue
    private long id;
    private long tempId;
    private String groupId;
    private String cpyId;
    private String userId;
    
    private String parentId;
    
    private String status;
    
    //计算Id
    private String pId;
    
    //订单流水号
    private String fieldName;
    private String fieldType;
    private String fieldValue;

    private String reffieldColumn;
    private String reffieldTable;
    
    private String refId;
    
    //0-引用 1-导入 2-公式
    private String rulesType;
    //计算公式，可以按列名或者 列的顺序
    private String rules;
    
    //顺序
    //private String order;
    //是否显示
    private String isColumnView;
    //税前税后
    private String isTax;
    private String isSalaryBill;
    
 

}
