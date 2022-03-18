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
@Table(name = "t_user_field_group")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class UserFieldGroup {
    @Id
    @GeneratedValue
    private long id;
    //订单流水号
    private String cpyId;
    private String name;

}
