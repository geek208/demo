package com.hadron.wfw.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_user")
@ToString(callSuper = true)
public class UserVO extends BaseEntityVO implements Serializable {
    private String email;
    private String username;
    private String password;
    private String nickName;
    private String role;

    private Integer status =1;

    private String remark;


    private List<MessageVO> messagesVO ;

    private String vCode;
    //被邀请码
    private  String inviteCode;
    //我的邀请码
    private  String myInvite;


}
