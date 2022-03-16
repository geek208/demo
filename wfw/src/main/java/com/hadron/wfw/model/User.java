package com.hadron.wfw.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_wfw_user")
public class User extends BaseEntity implements Serializable {
 
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String nickName;
    @Column(nullable = false)
    private String role;
    
    private String userName;

    private Integer status =1;

    private String remark;
    private String roleId;
    private String orgId;
    //岗位Id
    private String positionId;
    //职位ID
    private String jobId;
    //职级
    private String levelId;




    @Transient
    private String vCode;
    //我被邀请的码
    @Column
    private  String inviteCode="88888";
    //我的邀请码
    private  String myInvite;
    
    public UserVO toVO() {
        UserVO userVO = super.toVO(UserVO.class);
        userVO.setPassword(null);
        return userVO;
    }
}
