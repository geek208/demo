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
@Table(name = "t_salary_User")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SalaryUser {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String userId;
    private String templateId;
    //1--表示算薪，0-表示排除算薪 
    
    private String include;

}
