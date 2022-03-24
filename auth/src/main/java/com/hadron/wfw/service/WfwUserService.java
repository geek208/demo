package com.hadron.wfw.service;




import java.util.List;

import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwUserService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwUserService {
    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<WfwUser> getUserList();

    /**
     * Find user by id user.
     *
     * @param id the id
     * @return the user
     */
    WfwUser findUserById(long id);

    /**
     * Save.
     *
     * @param user the user
     */
    void save(WfwUser user);

    /**
     * Edit.
     *
     * @param user the user
     */
    void edit(WfwUser user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(long id);
}
