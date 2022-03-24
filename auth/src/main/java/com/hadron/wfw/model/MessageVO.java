package com.hadron.wfw.model;


import lombok.*;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname MessageVO.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageVO extends BaseEntityVO implements Serializable {

    private String messageContent;


    private UserVO userVO;


    private   List<MessageReceiverVO> messageReceivers;


}
