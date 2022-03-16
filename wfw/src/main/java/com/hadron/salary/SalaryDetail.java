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
 * User
 * <p/>
 * Created in 2018.07.25
 * <p/>
 *
 * @author <a href="https://github.com/liaozihong" style="background: #55a7e3;">Liaozihong</a>
 */
@Entity
@Table(name = "t_salary_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SalaryDetail {
    @Id
    @GeneratedValue
    private long id;
    //基本字段
    private String tempalteName;
    private String circle;
    private String cpyId;
    private String userId;
    private String batchId;
    
    //固定字段
    private String basePay;
    private String floatPay;
    
    private String supportOld;
    private String childrenEdu;
    
    //动态扩展字段
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;
    private String field10;
}
