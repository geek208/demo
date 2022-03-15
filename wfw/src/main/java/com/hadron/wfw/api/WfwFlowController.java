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
import com.hadron.wfw.model.WfwFormField;
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
@RequestMapping("/wfwFlow")
public class WfwFlowController {

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
	@RequestMapping("/createFlow")
	@ResponseBody
	public ResultData createFlow(WfwFlow flow) {

		wfwFlowRepository.save(flow);

		WfwActivity start = new WfwActivity();
		start.setFlowId(String.valueOf(flow.getId()));
		start.setName("开始");
		start.setPreActivity("0");

		// WfwActivity end = new WfwActivity();
		wfwActivityRepository.save(start);

		WfwActivity end = new WfwActivity();
		end.setFlowId(String.valueOf(flow.getId()));
		end.setName("结束");
		end.setNextActivity("0");

		wfwActivityRepository.save(end);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(flow);
		return data;
	}

	
	/**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getForm")
	@ResponseBody
	public ResultData getForm(String formId) {

		List formField = wfwFormFieldRepository.findByformId(formId);

		WfwFormV formV = new WfwFormV();
		formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(formV);
		return data;
	}

	/**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getFlow")
	@ResponseBody
	public ResultData getFlow(String flowId) {

		// List formField = wfwFormFieldRepository.findByformId(formId);

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		// data.setData(formV);
		return data;
	}

	/**
	 * 获取当前进程
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getProcess")
	@ResponseBody
	public ResultData getProcess(String pid) {

		// List formField = wfwFormFieldRepository.findByformId(formId);

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		// data.setData(formV);
		return data;
	}

	/**
	 * 获取流程的进程
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getProcessByFlowId")
	@ResponseBody
	public ResultData getProcessByFlowId(String pid) {

		// List formField = wfwFormFieldRepository.findByformId(formId);

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		// data.setData(formV);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/startProcess")
	@ResponseBody
	public ResultData startProcess(String flowId) {
		// 节点类型 1，开始节点 ：前序节点为0，
		// 2中间节点，前序节点不为0，
		// 3后续节点不为0，结束节点，后续节点为0

		WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));

		// 查找流程活动节点
		List wfwActivitys = wfwActivityRepository.findByflowId(flowId);

		// 查到开始节点，前序节点为0的是开始节点
		WfwActivity startActivity = (WfwActivity) wfwActivitys.get(0);

		// 查询开始节点后续节点
		// WfwActivity nextActivity = (WfwActivity)wfwActivitys.get(1);
		//
		WfwProcess process = new WfwProcess();
		process.setFlowId(flowId);
		process.setPName(flow.getFname() + flowId);

		//
		process.setCurrentActivityId(String.valueOf(startActivity.getId()));
		process.setNextActivityId(String.valueOf(startActivity.getNextActivity()));

		// 启动流程，
		wfwProcessRepository.save(process);

		WfwTask task = new WfwTask();
		//task.setStaskName(process.getPName());
		task.setPid(String.valueOf(process.getId()));
		task.setStatus(0);
		task.setUserId(String.valueOf(1));

		task.setFlowId(flowId);

		wfwTaskRepository.save(task);

		// //查到后续节点的处理人
		// List users =
		// wfwActivityRepository.findByActivityId(process.getNextActivityId());
		//
		// //新增处理任务
		// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
		// User object = (User) iterator.next();
		//
		// WfwTask task =new WfwTask();
		// task.setStaskName(process.getPName()+object.getUserName());
		// task.setPid(String.valueOf(process.getId()));
		// task.setStatus(0);
		// task.setUserId(String.valueOf(object.getId()));
		//
		// task.setFlowId(flowId);
		//
		// }

		ResultData data = new ResultData();

		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData("");
		return data;
	}
}