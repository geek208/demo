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
@Table(name = "t_salary_process")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SalaryProcess {
    @Id
    @GeneratedValue
    private long id;
    //基本字段
    private String tempalteName;
    private String circle;
    private String cpyId;
    private String userId;
    private String templateId;
    
    //private String circle;
    
    private String status;
    //处理阶段
    private String phase;
 
}
