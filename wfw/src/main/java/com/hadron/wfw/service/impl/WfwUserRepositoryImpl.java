package com.hadron.wfw.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.service.WfwUserRepository;
import com.hadron.wfw.service.WfwUserService;

import java.util.List;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwUserRepositoryImpl.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */


@Service
public class WfwUserRepositoryImpl implements WfwUserService {
    @Autowired
    private WfwUserRepository userRepository;

    @Override
    public List<WfwUser> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public WfwUser findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(WfwUser user) {
        userRepository.save(user);
    }

    @Override
    public void edit(WfwUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
