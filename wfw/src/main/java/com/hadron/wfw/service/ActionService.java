package com.hadron.wfw.service;




import java.util.List;

import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ActionService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface ActionService {

	void handOver(WfwUser user);
    
    
    
    void urge(WfwUser user);

    /**
     * Edit.
     *
     * @param user the user
     */
    void rejected(WfwUser user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void agree(long id);
}
