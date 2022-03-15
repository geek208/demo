package com.hadron.wfw.service;




import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.EasyPay;
import com.hadron.wfw.model.WfwActivity;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwActivityService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwActivityService {
    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<WfwActivity> getOrderList();

    /**
     * Find user by id user.
     *
     * @param id the id
     * @return the user
     */
    WfwActivity findOrderById(long id);

    /**
     * Save.
     *
     * @param user the user
     */
    @Transactional
    void save(WfwActivity user);

    /**
     * Edit.
     *
     * @param user the user
     */
    void edit(WfwActivity user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(long id);
    
    @Transactional
    void updatePayStatus(String orderSn, String status);
    
    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<WfwActivity> getEasyPayList();
}
