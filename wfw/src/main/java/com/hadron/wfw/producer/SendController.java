package com.hadron.wfw.producer;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hadron.wfw.WfwConfig;
import com.hadron.wfw.HttpAPIService;



/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname SendController.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@RestController
@RequestMapping("/apm")
public class SendController {

    @Autowired
    private Producer producer;
    @Autowired
    private WfwConfig bizmateConfig;
    
    
    @Autowired
    private KafkaTemplate kafkaTemplate;
    
    @Autowired
    private CloseableHttpClient httpClient;
    
    @Autowired
    private HttpAPIService httpAPIService;

    @RequestMapping(value = "/send")
    public String send() {
        try {
        	
        	//JSONObject o = new JSONObject();
        	//JSONObject resp = (JSONObject) restTemplate.getForEntity(bizmateConfig.bank, JSONObject.class);
			producer.send();
			 // 声明httpPost请求
	       // HttpPost httpPost = new HttpPost("http://www.baidu.com");
			//httpClient.execute(httpPost);
			//httpAPIService.doGet("http://www.baidu.com");
			httpAPIService.doGet("http://10.0.0.122:8085/mall/add?id=1&userName=1&password=1&age=1");
			httpAPIService.doGet("http://10.0.0.122:8085/mall/addOrder?id=22&name=2&money=2&fee=2");
			//http://10.0.0.122:8085/addOrder?id=22&name=2&money=2&fee=2
			///kafkaTemplate.send("test", "hellowold");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "{\"code\":0}";
    }
}
