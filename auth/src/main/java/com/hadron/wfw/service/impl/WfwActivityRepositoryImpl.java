package com.hadron.wfw.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.HttpAPIService;
import com.hadron.wfw.PayStatus;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.model.EasyPay;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.service.EasyPayRepository;
import com.hadron.wfw.service.EasyPayService;
import com.hadron.wfw.service.WfwActivityRepository;
import com.hadron.wfw.service.WfwActivityService;

import java.util.List;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwActivityRepositoryImpl.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */




@Service
public class WfwActivityRepositoryImpl implements WfwActivityService {
    @Autowired
    private WfwActivityRepository wfwActivityRepository;
    @Autowired
    private HttpAPIService httpAPIService;
    @Autowired
	private Environment env;
    private static Gson gson = new GsonBuilder().create();
	@Override
	public List<WfwActivity> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public WfwActivity findOrderById(long id) {
		// TODO Auto-generated method stub
		return wfwActivityRepository.findById(id);
	}
	@Override
	public void save(WfwActivity user) {
		// TODO Auto-generated method stub
		wfwActivityRepository.save(user);
	}
	@Override
	public void edit(WfwActivity user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatePayStatus(String orderSn, String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<WfwActivity> getEasyPayList() {
		// TODO Auto-generated method stub
		return null;
	}
    

}
