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
 * User
 * <p/>
 * Created in 2018.07.25
 * <p/>
 *
 * @author <a href="https://github.com/liaozihong" style="background: #55a7e3;">Liaozihong</a>
 */
@Entity
@Table(name = "t_salary_template")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SalaryTemplate {
    @Id
    @GeneratedValue
    private long id;
    //基本字段
    private String tempalteName;
    private String cpyId;
    //运营商Id
    private String opId;
    //计薪周期
    private String circle;
    
    //计薪周期
    private String status;

    //动态扩展字段
    //算薪人员清单
    private String includeList;
    //排除人员清单
    private String excluSionList;
}
