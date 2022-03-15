package com.hadron.wfw.model;

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

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class UserV {

	@Id
    @GeneratedValue
    private long id;
    private String userName;
    private String password;
    private int age;
}
