package com.hadron.wfw.api;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.Dozer;
import com.hadron.wfw.EntityUtils;
import com.hadron.wfw.GetPayNo;
import com.hadron.wfw.HttpAPIService;
import com.hadron.wfw.PayStatus;
import com.hadron.wfw.RedisService;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.model.EasyPay;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwFlow;
import com.hadron.wfw.model.WfwForm;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.WfwFormV;
import com.hadron.wfw.model.WfwProcess;
import com.hadron.wfw.model.WfwTask;
import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.producer.Producer;
import com.hadron.wfw.service.EasyPayService;
import com.hadron.wfw.service.WfwActivityRepository;
import com.hadron.wfw.service.WfwActivityService;
import com.hadron.wfw.service.WfwFlowRepository;
import com.hadron.wfw.service.WfwFormFieldRepository;
import com.hadron.wfw.service.WfwFormRepository;
import com.hadron.wfw.service.WfwProcessRepository;
import com.hadron.wfw.service.WfwTaskRepository;

import io.swagger.annotations.ApiOperation;

/**
 * User controller
 * <p/>
 * Created in 2018.11.16
 * <p/>
 *
 */
@Controller
@RequestMapping("/wfwtask")
public class WfwTaskController {

	/**
	 * The User service.
	 */
	@Autowired
	WfwActivityService wfwActivityService;
	@Autowired
	private HttpAPIService httpAPIService;
	@Autowired
	private Producer producer;
	@Autowired
	private KafkaTemplate kafkaTemplate;
	@Autowired
	private RedisService redisService;

	// @Autowired
	// private WfwActivityRepository wfwActivityRepository;

	@Autowired
	private WfwActivityRepository wfwActivityRepository;

	@Autowired
	private WfwFlowRepository wfwFlowRepository;

	@Autowired
	private WfwFormRepository wfwFormRepository;

	@Autowired
	private WfwFormFieldRepository wfwFormFieldRepository;
	@Autowired
	private WfwProcessRepository wfwProcessRepository;

	@Autowired
	private WfwTaskRepository wfwTaskRepository;

	@Autowired
	private Environment env;

	private static Gson gson = new GsonBuilder().create();


	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/addTask")
	@ResponseBody
	public ResultData addTask(WfwProcess process) {

		System.err.println();
		// 找到当前处理节点
		// WfwActivity users =
		// wfwActivityRepository.findByActivityId(process.getCurrentActivityId());
		List<Map<String, String>> objects = wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		String irsStr = JSON.toJSONString(objects);

		List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);

		// BeanUtil.

		// List users2 = Dozer.convert(objects, User.class);
		// //EntityUtils.castEntity(objects, User.class, new User());

		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			WfwUser user = (WfwUser) iterator.next();
			WfwTask task = new WfwTask();
			task.setTaskName(process.getPName());
			// task.setPid(String.valueOf(process.getId()));
			task.setPid(String.valueOf(process.getId()));
			task.setCreateDate(new Date());
			task.setUpdateDate(new Date());
			task.setStatus(0);
			task.setUserId(String.valueOf(user.getId()));
			task.setFlowId(process.getFlowId());
			wfwTaskRepository.save(task);
		}

		try {
			// producer.send();
			// redisService.set(message.getId(), message.getMsg());
			// System.err.print("send kfk express="+gson.toJson(message));
			// kafkaTemplate.send("mall", gson.toJson(message));
			// kafkaTemplate.send("pay", gson.toJson(message));

			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		// data.setData(pay.getPaySn());
		return data;
	}

	/**
	 * 处理 任务
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/doTask")
	@ResponseBody
	public ResultData doTask(String flowId, String pid, String userId, String taskId) {

		// 查看当前进程
		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(pid));

		WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));

		// WfwFlow wfwFlowRepository.findById(Long.parseLong(flowId));

		// 找到当前处理节点
		// List users =
		// wfwActivityRepository.findByActivityId(process.getCurrentActivityId());

		// 我的任务已处理

		// 更新处理节点
		process.setCurrentActivityId(process.getNextActivityId());

		// process.setNextActivityId(flow.g);

		// 回调业务

		// 流转下一个节点

		// 获取下一个节点的，处理人清单

		// 增加任务清单
		WfwTask wfwTask = new WfwTask();

		wfwTaskRepository.save(wfwTask);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(null);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getMyTask")
	@ResponseBody
	public ResultData getMyTask(String userId) {

		List tasks = wfwTaskRepository.findTask(userId);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(tasks);
		return data;
	}

	/**
	 * Add string. // * // * @param user // * the user // * @return the string
	 * // * @throws Exception //
	 */
	// @RequestMapping("/getEasyPayList")
	// @ApiOperation("支付单列表")
	// @ResponseBody
	// // @CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,
	// // RequestMethod.POST})
	// public ResultData getEasyPayList() throws Exception {
	//
	// ResultData data = new ResultData();
	// data.setCode(20000);
	// data.setSuccess(true);
	// data.setMessage("成功");
	//
	// // ArrayList list = new ArrayList();
	// // list.add(mallService.findOrderById(id));
	//
	// //data.setData(payService.getEasyPayList());
	//
	// return data;
	// }
}