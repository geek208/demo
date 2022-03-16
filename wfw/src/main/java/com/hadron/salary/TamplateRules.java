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
@Table(name = "t_template_rules")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class TamplateRules {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String rulesName;
    private String reffieldName;
    private String reffieldTable;
    private String refId;
    private String rulesType;
    
    //计算公式，可以按列名或者 列的顺序
    private String formula;
    private String itemId;

}
