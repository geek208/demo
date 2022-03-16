package com.hadron.salary;


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
@Table(name = "t_template_item")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class TemplateItem {
    @Id
    @GeneratedValue
    private long id;
    private long tempId;
    //订单流水号
    private String fieldName;
    private String fieldType;
    private String defaultValue;
    //顺序
    //private String order;
    //是否显示
    private String isColumnView;
    //税前税后
    private String isTax;
    private String isSalaryBill;
    private String groupId;

}
