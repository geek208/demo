package com.hadron.wfw.service;




import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.EasyPay;

/**
 * The interface User service.
 *
 * @author Liaozihong
 */
public interface EasyPayService {
    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<EasyPay> getOrderList();

    /**
     * Find user by id user.
     *
     * @param id the id
     * @return the user
     */
    EasyPay findOrderById(long id);

    /**
     * Save.
     *
     * @param user the user
     */
    @Transactional
    void save(EasyPay user);

    /**
     * Edit.
     *
     * @param user the user
     */
    void edit(EasyPay user);

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
    List<EasyPay> getEasyPayList();
}
