package com.hadron.wfw.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname MessageReceiverVO.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageReceiverVO extends BaseEntityVO implements Serializable {

    private UserVO user;

    private MessageVO message;
    /**
     * 已经接收？
     */
    private boolean received;


}
