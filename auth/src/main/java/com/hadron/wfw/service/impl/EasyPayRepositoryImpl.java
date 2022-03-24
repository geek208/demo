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
import com.hadron.wfw.service.EasyPayRepository;
import com.hadron.wfw.service.EasyPayService;

import java.util.List;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname EasyPayRepositoryImpl.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Service
public class EasyPayRepositoryImpl implements EasyPayService {
    @Autowired
    private EasyPayRepository payRepository;
    @Autowired
    private HttpAPIService httpAPIService;
    @Autowired
	private Environment env;
    private static Gson gson = new GsonBuilder().create();
    
    @Override
    public List<EasyPay> getOrderList() {
        return payRepository.findAll();
    }

    @Override
    public EasyPay findOrderById(long id) {
        return payRepository.findById(id);
    }

    @Override
    public void save(EasyPay user) {
    	payRepository.save(user);
    }

    @Override
    public void edit(EasyPay user) {
    	payRepository.save(user);
    }

    @Override
    public void delete(long id) {
    	payRepository.deleteById(id);
    }
    
    @Override
	public void updatePayStatus(String orderSn,String status) {
    	//回调通知 
//	    String result;
//		try {
//			result = httpAPIService.doGet(env.getProperty("spring.bizmate.order")+"/callbackPay?orderSn="+orderSn+"&payStatus=1");
//			ResultData data = gson.fromJson(result, ResultData.class);
//			    //如果回调成功
//			      String sucesss  = (String) data.getData();
//			      if(PayStatus.PAYSUCESS.getValue().equalsIgnoreCase(sucesss)){
			    	  //
			    	  payRepository.updatePayStatus(orderSn, status);
//			    }else{
//			    	new Exception("更新支付异常");
//			    }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
    
    
    @Override
    public List<EasyPay> getEasyPayList() {
        return payRepository.findAll();
    }
}
