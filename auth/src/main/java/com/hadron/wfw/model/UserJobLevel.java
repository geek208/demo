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
 * @classname WfwOrg.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Entity
@Table(name = "t_user_job_level")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class UserJobLevel {

    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String cnName;
    private Integer status =1;
    //职级类别 1-管理通道 2-专业通道
    private Integer type; 
}
