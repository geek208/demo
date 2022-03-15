package com.hadron.wfw.service;




import java.util.List;

import com.hadron.wfw.model.Activity;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActivityService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface ActivityService {


    /**
     * Save.
     *
     * @param user the user
     */
    void callBack(WfwUser activity);
    
    
    /**
     * Save.
     *
     * @param user the user
     */
    void prePost(WfwUser activity);
    
    
    
    WfwActivity addActivity(WfwActivity activity);
    
    void addLink(WfwActivity activity);
    
    void bindUser(WfwUser activity);

    /**
     * Edit.
     *
     * @param user the user
     */
    void addTask(WfwUser activity);

    /**
     * Delete.
     *
     * @param id the id
     */
    int dotask(String  taskId);
}
