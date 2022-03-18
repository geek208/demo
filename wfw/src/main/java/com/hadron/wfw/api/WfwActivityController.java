package com.hadron.wfw.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.ActivityType;
import com.hadron.wfw.ApprovalType;
import com.hadron.wfw.Dozer;
import com.hadron.wfw.EntityUtils;
import com.hadron.wfw.GetPayNo;
import com.hadron.wfw.HttpAPIService;
import com.hadron.wfw.IntervalUtil;
import com.hadron.wfw.OwerType;
import com.hadron.wfw.PayStatus;
import com.hadron.wfw.RedisService;
import com.hadron.wfw.Result;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.cache.UserCache;
import com.hadron.wfw.model.EasyPay;
import com.hadron.wfw.model.User;
import com.hadron.wfw.model.UserVO;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityRules;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwFlow;
import com.hadron.wfw.model.WfwForm;
import com.hadron.wfw.model.WfwFormField;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.WfwFormFieldV;
import com.hadron.wfw.model.WfwFormV;
import com.hadron.wfw.model.WfwLink;
import com.hadron.wfw.model.WfwProcess;
import com.hadron.wfw.model.WfwTask;
import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.producer.Producer;
import com.hadron.wfw.service.ActivityService;
import com.hadron.wfw.service.EasyPayService;
import com.hadron.wfw.service.OrgRepository;
import com.hadron.wfw.service.RoleRepository;
import com.hadron.wfw.service.UserRepository;
import com.hadron.wfw.service.WfwActivityRepository;
import com.hadron.wfw.service.WfwActivityRulesRepository;
import com.hadron.wfw.service.WfwActivityService;
import com.hadron.wfw.service.WfwFlowRepository;
import com.hadron.wfw.service.WfwFormFieldRepository;
import com.hadron.wfw.service.WfwFormRepository;
import com.hadron.wfw.service.WfwProcessRepository;
import com.hadron.wfw.service.WfwTaskRepository;
import com.hadron.wfw.service.WfwUserRepository;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/wfwactivity")
public class WfwActivityController {

	/**
	 * The User service.
	 */
	// @Autowired
	// WfwActivityService wfwActivityService;
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
	private WfwActivityRulesRepository wfwActivityRulesRepository;

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
	private ActivityService activityService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private OrgRepository orgRepository;

	@Autowired
	private WfwUserRepository wfwUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment env;

	private static Gson gson = new GsonBuilder().create();

	@Autowired
	UserCache userCache;

	public static final String COOKIE_NAME = "auth";

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

		flow.setCreateDate(new Date());
		flow.setFlowType("0");
		wfwFlowRepository.save(flow);

		WfwActivity start = new WfwActivity();
		start.setCreateDate(new Date());
		start.setFlowId(String.valueOf(flow.getId()));
		start.setName("开始");
		start.setPreActivity("0");

		// WfwActivity end = new WfwActivity();
		wfwActivityRepository.save(start);

		WfwActivity end = new WfwActivity();
		end.setCreateDate(new Date());
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
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/createForm")
	@ResponseBody
	public ResultData createForm(WfwForm form) {

		wfwFormRepository.save(form);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(form);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/createFlowField")
	@ResponseBody
	public ResultData createFormField(WfwFormField formfield) {
		// pay.setPaySn(GetPayNo.getOrderNo());
		formfield.setCreateDate(new Date());
		formfield.setUpdateDate(new Date());

		wfwFormFieldRepository.save(formfield);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(formfield);
		return data;
	}

	//
	// /**
	// * 获取
	// *
	// * @param id
	// * @return
	// */
	// @ResponseBody
	// @GetMapping("/activity/{id}")
	// public Result getMessage(@PathVariable Integer id) {
	// if (id == null) throw new NullPointerException("id不能为空");
	//
	// Message message = messageRepository.findById(id).orElse(new Message());
	//
	// return Result.buildSuccess(message==null?null:message, null);
	// }
	//

	@ResponseBody
	@RequestMapping("/updateActivity")
	public ResultData updateActivity(@RequestBody WfwActivity message) {
		// addOrUpdate(message);
		// 查找表单所有字段
		/// List<WfwFormField> wfwFormFields =
		// wfwFormFieldRepository.findByflowId(id);

		wfwActivityRepository.save(message);

		// 绑定规则字段到活动上
		// UPDATE t_wfw_form_field SET activity_id =?,rules =? WHERE id =?

		System.err.println(message.getId() + "  field " + message.getFieldId() + "  rules " + message.getRules());

		WfwActivityRules rules = new WfwActivityRules();
		rules.setActivityId(String.valueOf(message.getId()));
		rules.setFieldId(message.getFieldId());
		rules.setFlowId(message.getFlowId());
		rules.setUserId(message.getUserId());
		rules.setName(message.getName());
		rules.setRules(message.getRules());

		rules.setCreateDate(new Date());
		wfwFormFieldRepository.save(rules);

		//
		// wfwFormFieldRepository.updateFieldActivity(message.getFieldId(),
		// String.valueOf(message.getId()),message.getRules());

		// bindUser(String.valueOf(message.getId()), message.getUserId(),
		// message.getUserType());
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(message);
		return data;

	}

	/**
	 * 获取流程的进程
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@GetMapping("/getActivity/{id}")
	@ResponseBody
	public ResultData getActivity(@PathVariable long id) {

		WfwActivity process = wfwActivityRepository.findById(id);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(process);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/createActivity")
	@ResponseBody
	public ResultData createActivity(WfwActivity activity) {
		// pay.setPaySn(GetPayNo.getOrderNo());

		activity.setCreateDate(new Date());
		activity.setUpdateDate(new Date());
		// 默认为或签
		activity.setApproveType(ApprovalType.OR.getValue());
		// 默认按人
		activity.setUserType(OwerType.USER.getValue());
		// 结束节点
		WfwActivity endactitvity = wfwActivityRepository.findEndByflowId(activity.getFlowId());

		// 新加节点的后续为 ”结束“
		if (endactitvity != null) {
			//activity.setNextActivity(String.valueOf(endactitvity.getId()));
			wfwActivityRepository.save(activity);
		}
		// 更新前序节点的 后续节点
		WfwActivity pre = wfwActivityRepository.findById(Long.parseLong(activity.getPreActivity()));

		//pre.setNextActivity(String.valueOf(activity.getId()));

		// 增加连接线
		WfwLink link = new WfwLink();
		link.setPreId(activity.getPreActivity());
		//
		link.setNextId(String.valueOf(activity.getId()));
		wfwActivityRepository.save(link);

		//
		// activity.getId()
		// 修改前序的后续节点
		wfwActivityRepository.save(pre);

		// String[] userlist = activity.getUserId().split(",");
		//
		// // 绑定多个审批人
		// for (int i = 0; i < userlist.length; i++) {
		// WfwActivityUser au = new WfwActivityUser();
		// au.setActivityId(String.valueOf(activity.getId()));
		// au.setUserId(userlist[i]);
		// wfwActivityRepository.save(au);
		// }
		//
		// try {
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(activity);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/bindUser")
	@ResponseBody
	public ResultData bindUser(String activityId, String users, String owerType) {

		// 绑定用户
		if (OwerType.USER.getValue().equals(owerType)) {
			String[] userlist = users.split(",");
			// 绑定多个审批人
			for (int i = 0; i < userlist.length; i++) {
				WfwActivityUser au = new WfwActivityUser();
				au.setActivityId(activityId);
				au.setUserId(userlist[i]);
				au.setCreateDate(new Date());
				au.setUpdateDate(new Date());
				wfwActivityRepository.save(au);
			}
			// 绑定角色 下面的人
		} else if (OwerType.ROLE.getValue().equals(owerType)) {
			// List<Map<String, String>> objects =
			// userRepository.findByRole(users);
			// String irsStr = JSON.toJSONString(objects);
			// List<WfwUser> users2 = JSON.parseArray(irsStr, WfwUser.class);
			// for (WfwUser user : users2) {
			// WfwActivityUser au = new WfwActivityUser();
			// au.setActivityId(activityId);
			// au.setUserId(String.valueOf(user.getId()));
			// au.setCreateDate(new Date());
			// au.setUpdateDate(new Date());
			// wfwActivityRepository.save(au);
			// }

			// 绑定部门
		} else if (OwerType.ORG.getValue().equals(owerType)) {

		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(users);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/addTask")
	@ResponseBody
	public ResultData addTask(String pid) {

		System.err.println();
		// 找到当前处理节点
		// WfwActivity users =
		// wfwActivityRepository.findByActivityId(process.getCurrentActivityId());
		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(pid));

		// 查找当前的节点的处理人
		List<Map<String, String>> objects = wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		String irsStr = JSON.toJSONString(objects);

		List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);

		// BeanUtil.

		// List users2 = Dozer.convert(objects, User.class);
		// //EntityUtils.castEntity(objects, User.class, new User());
		// 添加到任务列表

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
			// 设置当前处理节点
			task.setCurrentId(process.getCurrentActivityId());
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
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/addWfwActivity")
	@ResponseBody
	public ResultData addWfwActivity(WfwActivity activity) {

		// activityService
		activityService.addActivity(activity);
		List<Map<String, String>> objects = wfwActivityRepository.findNext(activity.getPreActivity());

		String irsStr = JSON.toJSONString(objects);
		List<WfwActivity> users = JSON.parseArray(irsStr, WfwActivity.class);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(users);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/addTaskAct")
	@ResponseBody
	public ResultData addTaskAct(WfwProcess process, WfwActivity current) {

		 List<User> users = new ArrayList();

		// userRepository.findUserByRole(current.getUserId());
		if (current.getUserType().equals(OwerType.ROLE.getValue())) {
			users = userRepository.findUserByRole(current.getUserId());
			System.err.println("找到角色下的人=" + process.getCurrentActivityId() + "+找到角色下的人===" + users.size());
			// 查找部门下的人
		} else if (current.getUserType().equals(OwerType.ORG.getValue())) {
			users = userRepository.findUserByOrg(current.getUserId());
			System.err.println("找到部门下的人=" + process.getCurrentActivityId() + "+找到部门下的人===" + users.size());
			// 缺省是用户
		} else if (current.getUserType().equals(OwerType.USER.getValue())){
			users.add(userRepository.findById(Integer.parseInt(current.getUserId())));
			
			System.err.println("缺省是用户的人=" + process.getCurrentActivityId() + "+缺省是用户下的人===" + users.size());
		}

		// List<Map<String, String>> objects =
		// wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		// System.err.print("查找当前的节点的处理人 =" + objects.size());
		// // List<User> user3 =
		// //
		// wfwActivityRepository.findByUserActivityId(process.getCurrentActivityId());
		// String irsStr = JSON.toJSONString(objects);
		// List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);

		// 添加到任务列表
        if(users !=null && users.size() >0){
        	for (Iterator iterator = users.iterator(); iterator.hasNext();) {
    			User user = (User) iterator.next();
    			WfwTask task = new WfwTask();
    			task.setTaskName(process.getPName() + "-" + current.getName());
    			// task.setPid(String.valueOf(process.getId()));
    			task.setPid(String.valueOf(process.getId()));
    			task.setCreateDate(new Date());
    			task.setUpdateDate(new Date());
    			task.setStatus(0);
    			task.setUserId(String.valueOf(user.getId()));
    			task.setFlowId(process.getFlowId());
    			task.setCurrentId(process.getCurrentActivityId());
    			wfwTaskRepository.save(task);
    		}

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
	@RequestMapping("/doTaskByUser")
	@ResponseBody
	public ResultData doTaskByUser(String flowId, String pid, String userId, String taskId) {

		// 查看当前进程
		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(pid));

		// 更新任务处理状态为已处理，

		// 更新处理节点
		process.setCurrentActivityId(process.getNextActivityId());

		WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));

		// WfwFlow wfwFlowRepository.findById(Long.parseLong(flowId));

		// 找到当前处理节点
		// List users =
		// wfwActivityRepository.findByActivityId(process.getCurrentActivityId());

		// 我的任务已处理

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
	 * 处理 任务
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	// @RequestMapping("/doTask")
	@GetMapping("/dotask/{id}")
	@ResponseBody
	public ResultData doTask(@PathVariable String id) {

		// doTask2(id);

		// 查看当前任务
		WfwTask task = wfwTaskRepository.findById(Long.parseLong(id));

		// wfwProcessRepository.
		// 更新为已处理
		wfwTaskRepository.updateTaskStatus(id, "1");
		// 查看当前进程
		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(task.getPid()));

		//WfwActivity current = wfwActivityRepository.findById(Long.parseLong(process.getCurrentActivityId()));
		
		List<WfwFormField> formFields = wfwFormFieldRepository.findByPid(task.getPid());
		
		this.doNext(process, formFields);
		
		

//		// 查找当前节点，判定审批类别 0，或签 ，1 ，会签 2，依次审批
//		if (ApprovalType.OR.getValue().equals(current.getApproveType())) {
//			
//			
//			List<Map<String, String>> objects = wfwActivityRepository.findNext(process.getCurrentActivityId());
//			String irsStr = JSON.toJSONString(objects);
//			List<WfwActivity> nexts = JSON.parseArray(irsStr, WfwActivity.class);
//			System.err.println("当前节点=" + process.getCurrentActivityId() + "+找到后续节点个数===" + nexts.size());
//			
//
//			System.err.println("或签=" + current.getApproveType());
//			// 修改当前节点，为审批2
//			//process.setCurrentActivityId(process.getNextActivityId());
//			// process.setCurrentActivityName(currentActivityName);
//			//
//			// 查找审批2,如果有多个分支,则按照规则条件走分支
//			WfwActivity next = wfwActivityRepository.findById(Long.parseLong(process.getNextActivityId()));
//
//			// 修改下一个节点为审批2的下一个节点
//			if (next != null && next.getNextActivity() != null) {
//				process.setNextActivityId(next.getNextActivity());
//				//
//			} else {
//
//				// 如果后续审批2的后续为空 ，则修改当前节点为结束
//				// process.setCurrentActivityId("1");
//
//				process.setNextActivityId("0");
//			}
//			wfwProcessRepository.save(process);
//
//			// 更新任务处理状态为已处理，
//			// 查找当前的节点的处理人，增加下一个节点的处理人
//			if (next != null) {
//				addTaskAct(process, next);
//				// List<Map<String, String>> objects = wfwActivityRepository
//				// .findByUActivityId(String.valueOf(next.getId()));
//				// String irsStr = JSON.toJSONString(objects);
//				// List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);
//				// for (Iterator iterator = users.iterator();
//				// iterator.hasNext();) {
//				// WfwUser user = (WfwUser) iterator.next();
//				// WfwTask task2 = new WfwTask();
//				// task2.setTaskName(next.getName());
//				// // task.setPid(String.valueOf(process.getId()));
//				// task2.setPid(String.valueOf(process.getId()));
//				// task2.setCreateDate(new Date());
//				// task2.setUpdateDate(new Date());
//				// task2.setCurrentId(String.valueOf(next.getId()));
//				// // 待处理
//				// task2.setStatus(0);
//				// task2.setUserId(String.valueOf(user.getId()));
//				// task2.setFlowId(process.getFlowId());
//				// wfwTaskRepository.save(task2);
//				// }
//			}
//
//		} else if (ApprovalType.AND.getValue().equals(current.getApproveType())) {
//			// 查找本地节点待处理人数
//			// 查找已经处理的人数
//			// 如果已处理人数 等于待处理人数
//			// 本节点所有人已经处理完
//			System.err.println("会签=" + current.getApproveType());
//
//			List list = wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()),
//					process.getCurrentActivityId());
//
//			// 未全部处理
//			if (list != null && list.size() > 0) {
//				ResultData data = new ResultData();
//				data.setCode(200);
//				data.setSuccess(true);
//				data.setMessage("成功");
//				data.setData(process);
//				return data;
//
//				// 走下一个节点
//			} else {
//				// 修改当前节点，为审批2
//				process.setCurrentActivityId(process.getNextActivityId());
//				//
//				// 查找审批2
//				WfwActivity next = wfwActivityRepository.findById(Long.parseLong(process.getNextActivityId()));
//				// 修改下一个节点为审批2的下一个节点
//				if (next != null && next.getNextActivity() != null) {
//					process.setNextActivityId(next.getNextActivity());
//					//
//				} else {
//
//					// 如果后续审批2的后续为空 ，则修改当前节点为结束
//					// process.setCurrentActivityId("1");
//
//					process.setNextActivityId("0");
//				}
//				wfwProcessRepository.save(process);
//
//				// 更新任务处理状态为已处理，
//				// 查找当前的节点的处理人，增加下一个节点的处理人
//				if (next != null) {
//
//					addTaskAct(process, next);
//
//				}
//			}
//
//			System.err.println("会签 完成=" + current.getApproveType());
//
//		}

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(process);
		return data;
	}

	/**
	 * 处理 任务
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/doTask2")
	@ResponseBody
	public ResultData doTask2(String taskId) {
		int ret = activityService.dotask(taskId);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(ret);
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
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getMyTaskTodoList")
	@ResponseBody
	public ResultData getMyTaskTodoList(@CookieValue(value = COOKIE_NAME, defaultValue = "") String auth) {

		UserVO cache = userCache.getCache(auth);

		// if(cache ==null) throw new Exception("");

		List<WfwTask> tasks = wfwTaskRepository.findTodoTask(String.valueOf(cache.getId()), "0");

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(tasks);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getMyTaskDoneList")
	@ResponseBody
	public ResultData getMyTaskDoneList(@CookieValue(value = COOKIE_NAME, defaultValue = "") String auth) {

		UserVO cache = userCache.getCache(auth);
		List<WfwTask> tasks = wfwTaskRepository.findTodoTask(String.valueOf(cache.getId()), "1");
		// List<WfwTask> tasks = wfwTaskRepository.findTodoTask("7", "1");

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(tasks);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@GetMapping("/getActivityList/{id}")
	@ResponseBody
	public ResultData getActivityList(@PathVariable String id) {

		// 查找流程活动节点
		List<WfwActivity> wfwActivitys = wfwActivityRepository.findByflowId(id);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(wfwActivitys);
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

		// WfwForm form = wfwFormRepository.findById(Long.parseLong(formId));

		WfwForm form = wfwFormRepository.findById(93);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(form);
		return data;
	}

	/**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getFormList2")
	@ResponseBody
	@GetMapping
	public Result getFormList2(Integer page, Integer pageSize) {

		Page<WfwForm> messages = wfwFormRepository.findAll(Example.of(WfwForm.builder().build()),
				PageRequest.of(page - 1, pageSize));

		List<WfwForm> contents = messages.getContent();

		Result ret = Result.buildPageObject(messages.getTotalElements(), contents);

		return ret;
	}

	/**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/getFormList3")
	@ResponseBody
	@GetMapping
	public ResultData getFormList3(Integer page, Integer pageSize) {

		Page<WfwForm> messages = wfwFormRepository.findAll(Example.of(WfwForm.builder().build()),
				PageRequest.of(page - 1, pageSize));

		List<WfwForm> contents = messages.getContent();

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(contents);
		return data;
	}

	/**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	// @RequestMapping("/getFormFields")
	@GetMapping("/getFormFields/{id}")
	@ResponseBody
	public ResultData getFormFields(@PathVariable String id) {

		List<WfwFormField> formField = wfwFormFieldRepository.findByflowId(id);

		// WfwFormV formV = new WfwFormV();
		// formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(formField);
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

		WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);

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
	@RequestMapping("/getFlowList")
	@ResponseBody
	public ResultData getFlowList() {

		List<WfwFlow> flows = wfwFlowRepository.findAll();

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(flows);
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

		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(pid));

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(process);
		return data;
	}

	/**
	 * 获取流程的进程
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@GetMapping("/getProcessByFlowId/{id}")
	@ResponseBody
	public ResultData getProcessByFlowId(@PathVariable String id) {

		List<WfwProcess> process = wfwProcessRepository.findProcessByflowId(id);
		
		
		
		for (WfwProcess wfwProcess : process) {
			
			int toDoNum =  wfwTaskRepository.countTaskFinish(String.valueOf(wfwProcess.getId()), 0);
			int doneNum =  wfwTaskRepository.countTaskFinish(String.valueOf(wfwProcess.getId()), 1);
			wfwProcess.setToDoNum(toDoNum);
			wfwProcess.setDoneNum(doneNum);
			//更新计算
			if(toDoNum == 0 ){
				wfwProcess.setTaskStatus(wfwProcess.getCurrentActivityName()+"[已完成]");
			}else{
				wfwProcess.setTaskStatus("审批中");
			}
			//wfwProcessRepository.save(wfwProcess);
			
			System.err.println("进程=[" + wfwProcess.getId()+"] todo =["+toDoNum+"] done=["+doneNum+"]");
		}
		

		// WfwFormV formV =new WfwFormV();
		// formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(process);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	// @RequestMapping("/startProcess")
	@GetMapping("/startProcess/{id}")
	@ResponseBody
	public ResultData startProcess(@PathVariable String id) {
		// flowId = "1";
		// 节点类型 1，开始节点 ：前序节点为0，
		// 2中间节点，前序节点不为0，
		// 3后续节点不为0，结束节点，后续节点为0

		WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(id));

		// 查找流程所有活动节点
		List wfwActivitys = wfwActivityRepository.findByflowId(id);
		// 判定是开始节点，查到开始节点，前序节点为0的是开始节点
		WfwActivity startActivity = (WfwActivity) wfwActivitys.get(0);

		// 生成进程
		WfwProcess process = new WfwProcess();
		process.setFlowId(id);
		process.setPName(flow.getFname() + "-" + id);
		process.setCreateDate(new Date());

		// 设置下一处理节点
		//WfwActivity current2 = wfwActivityRepository.findById(Long.parseLong(startActivity.getNextActivity()));

		// List<.> nexts
		// wfwActivityRepository.findNext(startActivity.getNextActivity());

		// 设置当前处理节点
		// process.setCurrentActivityId(String.valueOf(current.getId()));
		// process.setCurrentActivityName(current.getName());

		process.setCurrentActivityId(String.valueOf(startActivity.getId()));
		// process.setCurrentActivityName(current.getName());

		// process.setNextActivityId(String.valueOf(current.getNextActivity()));
		// process.setCurrentActivityName(current.getName());
		// 启动流程，
		wfwProcessRepository.save(process);

		// 查找表单所有字段
		List<WfwFormField> wfwFormFields = wfwFormFieldRepository.findByflowId(id);

		System.err.print("生成进程的表单快照,每个进程生成一份    表单字段=" + wfwFormFields.size());

		// 生成进程的表单快照,每个进程生成一份
		List<WfwFormField> newwfwFormFields = new ArrayList();
		for (WfwFormField object : wfwFormFields) {
			// object.setUserId(userId);
			WfwFormField field = new WfwFormField();
			field.setName(object.getName());
			field.setFlowId(object.getFlowId());
			field.setFormId(object.getFormId());
			field.setUserId(object.getUserId());
			field.setCreateDate(new Date());
			// 绑定本进程
			field.setPId(String.valueOf(process.getId()));
			// field.setActivityId(object.getActivityId());
			field.setParentId(String.valueOf(object.getId()));
			field.setRules(object.getRules());
			field.setFieldType(object.getFieldType());
			wfwFormFieldRepository.save(field);
			newwfwFormFields.add(field);
		}

		// List<Map<String, String>> objects =
		// wfwActivityRepository.findNext(String.valueOf(startActivity.getId()));
		// String irsStr = JSON.toJSONString(objects);
		// List<WfwActivity> nexts = JSON.parseArray(irsStr, WfwActivity.class);
		// System.err.println(""+startActivity.getNextActivity()+"+找到后续节点个数==="
		// + nexts.size());
		//
		// // 如果后续节点大于1，则表示分叉
		// if (nexts != null && nexts.size() > 1) {
		// // 找本节点的条件分支
		// //field
		// }

		// 添加当前节点的处理人
		// addTask(String.valueOf(process.getId()));
		// 查找当前的节点的处理人
		//

		// WfwActivity wfwActivity=
		// wfwActivityRepository.findById(Long.parseLong(process.getCurrentActivityId()));
		// 默认是人员
		// userRepository.findById(Integer.parseInt(current.getUserId()));
		// List<User> users = new ArrayList();
		//
		// // userRepository.findUserByRole(current.getUserId());
		// if (current.getUserType().equals(OwerType.ROLE.getValue())) {
		// users = userRepository.findUserByRole(current.getUserId());
		// // 查找部门下的人
		// } else if (current.getUserType().equals(OwerType.ORG.getValue())) {
		// userRepository.findUserByOrg(current.getUserId());
		//
		// // 缺省是用户
		// } else {
		// users.add(userRepository.findById(Integer.parseInt(current.getUserId())));
		// }

		// List<Map<String, String>> objects =
		// wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		// System.err.print("查找当前的节点的处理人 =" + objects.size());
		// // List<User> user3 =
		// //
		// wfwActivityRepository.findByUserActivityId(process.getCurrentActivityId());
		// String irsStr = JSON.toJSONString(objects);
		// List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);

		// 添加到任务列表
		// System.err.print("查找当前的节点的处理人 =" + users.size());
		//
		// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
		// User user = (User) iterator.next();
		// WfwTask task = new WfwTask();
		// task.setTaskName(process.getPName() + "-" + current.getName());
		// // task.setPid(String.valueOf(process.getId()));
		// task.setPid(String.valueOf(process.getId()));
		// task.setCreateDate(new Date());
		// task.setUpdateDate(new Date());
		// task.setStatus(0);
		// task.setUserId(String.valueOf(user.getId()));
		// task.setFlowId(process.getFlowId());
		// task.setCurrentId(process.getCurrentActivityId());
		// wfwTaskRepository.save(task);
		// }

		// WfwTask task = new WfwTask();
		// task.setTaskName(process.getPName());
		// task.setPid(String.valueOf(process.getId()));
		// task.setStatus(0);
		// task.setUserId(String.valueOf(1));
		//
		// task.setFlowId(flowId);
		//
		// wfwTaskRepository.save(task);

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
		data.setData(newwfwFormFields);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/apply")
	// @P
	@ResponseBody
	// @RequestParam(value=“XXX”,required=false)List
	public ResultData apply(@RequestBody List<WfwFormField> formfields) {

		// // 节点类型 1，开始节点 ：前序节点为0，
		// // 2中间节点，前序节点不为0，
		// // 3后续节点不为0，结束节点，后续节点为0
		//
		// WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));
		//
		// // 查找流程活动节点
		// List wfwActivitys = wfwActivityRepository.findByflowId(flowId);
		//
		// // 查到开始节点，前序节点为0的是开始节点
		// WfwActivity startActivity = (WfwActivity) wfwActivitys.get(0);
		//
		// // 生成进程
		// WfwProcess process = new WfwProcess();
		// process.setFlowId(flowId);
		// process.setPName(flow.getFname() + "-" + flowId);
		// process.setCreateDate(new Date());
		//

		// 循环更新字段值
		for (WfwFormField object : formfields) {
			wfwFormFieldRepository.updateFieldValue(String.valueOf(object.getId()), object.getFieldvalue());
		}

		//查找当前进程
		WfwProcess process = null;
		if (formfields != null && formfields.size() >= 1) {
			WfwFormField f = (WfwFormField) formfields.get(0);
			process = wfwProcessRepository.findById(Long.parseLong(f.getPId()));
		}
		
		//查找当前节点
		WfwActivity current = wfwActivityRepository.findById(Long.parseLong(process.getCurrentActivityId()));
		
		System.err.println("当前节点=" + process.getCurrentActivityId() + "+名字===" + current.getName());
		
		//查找后续节点
		List<Map<String, String>> objects = wfwActivityRepository.findNext(process.getCurrentActivityId());
		String irsStr = JSON.toJSONString(objects);
		List<WfwActivity> nexts = JSON.parseArray(irsStr, WfwActivity.class);
		
		System.err.println("当前节点=" + process.getCurrentActivityId() + "+找到后续节点个数===" + nexts.size());

		 
			if (nexts != null && nexts.size() >= 1) {
				// 遍历后续节点
				int i=0;
				for (WfwActivity wfwActivity : nexts) {
					
					//如果是分叉    // 如果后续节点大于1，则表示有分叉
					if(ActivityType.BRANCH.getValue().equalsIgnoreCase(wfwActivity.getActivtiyType())){

				    System.err.println("查找第["+i+"] 节点id=" + wfwActivity.getId() +  "节点名字=" + wfwActivity.getName() +"节点类型="+wfwActivity.getActivtiyType());
					// 找到本节点的规则
					//WfwActivityRules rule = wfwActivityRepository.findRulesById(String.valueOf(wfwActivity.getId()));
					List<Map<String, String>> obj = wfwActivityRepository.findRulesById(String.valueOf(wfwActivity.getId()));
					String irs= JSON.toJSONString(obj);
					List<WfwActivityRules> rules = JSON.parseArray(irs, WfwActivityRules.class);
					
					System.err.println("查找第["+i+"] 节点id=" + wfwActivity.getId() +  " 的规则 个数=" + rules.size());
					
					if(rules !=null && rules.size() >0){
						//目前只支持单条规则
						WfwActivityRules rule= (WfwActivityRules)rules.get(0);
						
						if(rule !=null){
							// 提取规则
							String interval = rule.getRules();
							// 找本节点的条件分支
							// field
							for (WfwFormField object : formfields) {
								
								 // 如果提交字段的值是，本节点设置的规则，则进行比对。 // 输入值50， $表示输入值，
								 if(object.getParentId().equals(rule.getFieldId())){
									 
									 IntervalUtil a = new IntervalUtil();
									 boolean isOk= a.isInTheInterval(object.getFieldvalue(), interval);
									   
									    //如果满足输入值，满足此规则，则走这条分支
									   if(isOk){
										   
										     //给下一个节点 添加任务
											 addTaskAct(process, wfwActivity);
											 //// 设置当前处理节点
											 process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
											 process.setCurrentActivityName(wfwActivity.getName());
											 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
											 
											    int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), String.valueOf(wfwActivity.getId()));
												int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), String.valueOf(wfwActivity.getId()));
												process.setToDoNum(toDoNum);
												process.setDoneNum(doneNum);
												//更新计算
												if(toDoNum == 0 ){
													process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
												}else{
													process.setTaskStatus("审批中");
												}
											 
											 wfwProcessRepository.save(process);
											
												
											 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
											 
									         break;
									    // 否则 判断下一条	   
									   }else{
										   continue;
									   }

								 }
							}
						}
					}
					i++;
				} else if (ActivityType.APPROVER.getValue().equalsIgnoreCase(current.getActivtiyType())){
					 //给下一个节点 添加任务
					 addTaskAct(process, wfwActivity);	

					 //WfwActivity  wfwActivity =   (WfwActivity)nexts.get(0);
					 System.err.println("后续节点 是 普通审批 =" + wfwActivity.getId() + "+名字===" + wfwActivity.getName());
					 process.setCurrentActivityName(wfwActivity.getName());
					 process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
					 
				    int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
					int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
					process.setToDoNum(toDoNum);
					process.setDoneNum(doneNum);
					//更新计算
					if(toDoNum == 0 ){
						process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
					}else{
						process.setTaskStatus("审批中");
					}
						
					 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
					 wfwProcessRepository.save(process);
					 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
					
					
				}
			}
		
		//		
		}else{
			System.err.println("后续节点 是 其他类型=");
		}
		
        




		// // 设置下一处理节点
		// WfwActivity current =
		// wfwActivityRepository.findById(Long.parseLong(startActivity.getNextActivity()));
		// // 设置当前处理节点
		// process.setCurrentActivityId(String.valueOf(current.getId()));
		//
		//
		// process.setNextActivityId(String.valueOf(current.getNextActivity()));
		// // 启动流程，
		// wfwProcessRepository.save(process);
		//
		// //设置 表单值

		//
		// // 添加当前节点的处理人
		// // addTask(String.valueOf(process.getId()));
		// // 查找当前的节点的处理人
		// List<Map<String, String>> objects =
		// wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		//
		// //List<User> user3 =
		// wfwActivityRepository.findByUserActivityId(process.getCurrentActivityId());
		//
		// String irsStr = JSON.toJSONString(objects);
		// List<User> users = JSON.parseArray(irsStr, User.class);
		//
		// // BeanUtil.
		// // List users2 = Dozer.convert(objects, User.class);
		// // //EntityUtils.castEntity(objects, User.class, new User());
		// // 添加到任务列表
		//
		// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
		// User user = (User) iterator.next();
		// WfwTask task = new WfwTask();
		// task.setTaskName(current.getName());
		// // task.setPid(String.valueOf(process.getId()));
		// task.setPid(String.valueOf(process.getId()));
		// task.setCreateDate(new Date());
		// task.setUpdateDate(new Date());
		// task.setStatus(0);
		// task.setUserId(String.valueOf(user.getId()));
		// task.setFlowId(process.getFlowId());
		// task.setCurrentId(process.getCurrentActivityId());
		// wfwTaskRepository.save(task);
		// }

		// WfwTask task = new WfwTask();
		// task.setTaskName(process.getPName());
		// task.setPid(String.valueOf(process.getId()));
		// task.setStatus(0);
		// task.setUserId(String.valueOf(1));
		//
		// task.setFlowId(flowId);
		//
		// wfwTaskRepository.save(task);

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
		// data.setData(process);
		return data;
	}
	
	
	// 处理后续
	public void doNext(WfwProcess process,List<WfwFormField> formFields){
		//查找后续节点
		List<Map<String, String>> objects = wfwActivityRepository.findNext(process.getCurrentActivityId());
		String irsStr = JSON.toJSONString(objects);
		List<WfwActivity> nexts = JSON.parseArray(irsStr, WfwActivity.class);
		
		System.err.println("当前节点=" + process.getCurrentActivityId() + "+找到后续节点个数===" + nexts.size());

		   // 如果后续节点大于1，则表示有分叉
			if (nexts != null ) {
				// 遍历后续节点
				int i=0;
				for (WfwActivity wfwActivity : nexts) {
					
					//如果是分叉
					if(ActivityType.BRANCH.getValue().equalsIgnoreCase(wfwActivity.getActivtiyType())){

				    System.err.println("查找第["+i+"] 节点id=" + wfwActivity.getId() +  "节点名字=" + wfwActivity.getName() +"节点类型="+wfwActivity.getActivtiyType());
					// 找到本节点的规则
					//WfwActivityRules rule = wfwActivityRepository.findRulesById(String.valueOf(wfwActivity.getId()));
					List<Map<String, String>> obj = wfwActivityRepository.findRulesById(String.valueOf(wfwActivity.getId()));
					String irs= JSON.toJSONString(obj);
					List<WfwActivityRules> rules = JSON.parseArray(irs, WfwActivityRules.class);
					
					System.err.println("查找第["+i+"] 节点id=" + wfwActivity.getId() +  " 的规则 个数=" + rules.size());
					
					if(rules !=null && rules.size() >0){
						//目前只支持单条规则
						WfwActivityRules rule= (WfwActivityRules)rules.get(0);
						
						if(rule !=null){
							// 提取规则
							String interval = rule.getRules();
							// 找本节点的条件分支
							// field
							for (WfwFormField object : formFields) {
								
								 // 如果提交字段的值是，本节点设置的规则，则进行比对。 // 输入值50， $表示输入值，
								 if(object.getParentId().equals(rule.getFieldId())){
									 
									 IntervalUtil a = new IntervalUtil();
									 boolean isOk= a.isInTheInterval(object.getFieldvalue(), interval);
									   
									    //如果满足输入值，满足此规则，则走这条分支
									   if(isOk){
										   
											 //// 设置当前处理节点
										   if (ApprovalType.OR.getValue().equals(wfwActivity.getApproveType())) {
											     System.err.println("或签=====================" + wfwActivity.getApproveType());
											     process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
											     process.setCurrentActivityName(wfwActivity.getName());
											     
											 	int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
												int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
												process.setToDoNum(toDoNum);
												process.setDoneNum(doneNum);
												//更新计算
												if(toDoNum == 0 ){
													process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
												}else{
													process.setTaskStatus("审批中");
												}
												
												 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
												 wfwProcessRepository.save(process);
												 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
												 //给下一个节点 添加任务
												 addTaskAct(process, wfwActivity);
										         continue;
										   }else{
											   
											   System.err.println("会签================" + wfwActivity.getApproveType());
											   int notDone = wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()),
														process.getCurrentActivityId());
												// 未全部处理
												if (notDone >0) {
													continue;
													// 走下一个节点
												}else{
													process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
													process.setCurrentActivityName(wfwActivity.getName());
													
												 	int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
													int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
													process.setToDoNum(toDoNum);
													process.setDoneNum(doneNum);
													//更新计算
													if(toDoNum == 0 ){
														process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
													}else{
														process.setTaskStatus("审批中");
													}
													
													 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
													 wfwProcessRepository.save(process);
													 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
													 //给下一个节点 添加任务
													 addTaskAct(process, wfwActivity);
											         break;
												}
										   }
											 
									    // 否则 判断下一条	   
									   }else{
										   continue;
									   }
								 }
							}
						}
					}
					i++;
				} else if (ActivityType.APPROVER.getValue().equalsIgnoreCase(wfwActivity.getActivtiyType())){
					
					 //// 设置当前处理节点
					   if (ApprovalType.OR.getValue().equals(wfwActivity.getApproveType())) {
						     System.err.println("或签=====================" + wfwActivity.getApproveType());
						     process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
						     process.setCurrentActivityName(wfwActivity.getName());
							 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
						     int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
								int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
								process.setToDoNum(toDoNum);
								process.setDoneNum(doneNum);
								//更新计算
								if(toDoNum == 0 ){
									process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
								}else{
									process.setTaskStatus("审批中");
								}
								
							 wfwProcessRepository.save(process);
							 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
							 //给下一个节点 添加任务
							 addTaskAct(process, wfwActivity);
					         continue;
					   }else{
						   
						   System.err.println("会签================" + wfwActivity.getApproveType());
						   int toDo = wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()),
									process.getCurrentActivityId());
							// 未全部处理
							if (toDo >0) {
								continue;
								// 走下一个节点
							}else{
								process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
								process.setCurrentActivityName(wfwActivity.getName());
								 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
								int toDoNum =  wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
								int doneNum =  wfwTaskRepository.findTaskFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
								process.setToDoNum(toDoNum);
								process.setDoneNum(doneNum);
								//更新计算
								if(toDoNum == 0 ){
									process.setTaskStatus(process.getCurrentActivityName()+"[已完成]");
								}else{
									process.setTaskStatus("审批中");
								}
								
								 wfwProcessRepository.save(process);
								 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
								 //给下一个节点 添加任务
								 addTaskAct(process, wfwActivity);
						         break;
							}
					   }
//					 //WfwActivity  wfwActivity =   (WfwActivity)nexts.get(0);
//					 System.err.println("后续节点 是 普通审批 =[" + wfwActivity.getId() + "]   名字===[" + wfwActivity.getName());
//					 process.setCurrentActivityId(String.valueOf(wfwActivity.getId()));
//					 process.setCurrentActivityName(wfwActivity.getName());
//					 //WfwActivity  wfwActivity =   (WfwActivity)nexts.get(0);
//					 System.err.println("更新当前节点=[" + process.getCurrentActivityId() + "]   名字===["+process.getCurrentActivityName()+"]");
//					 //process.setNextActivityId(String.valueOf(wfwActivity.getNextActivity()));
//					 wfwProcessRepository.save(process);
//					 
//					 //给下一个节点 添加任务
//					 addTaskAct(process, wfwActivity);	
				}
			}
		
		//		
		}else{
			System.err.println("后续节点 是 其他类型=");
		}
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/startFormProcess")
	@ResponseBody
	public ResultData startFormProcess(WfwFormFieldV WfwFormField) {

		// // 节点类型 1，开始节点 ：前序节点为0，
		// // 2中间节点，前序节点不为0，
		// // 3后续节点不为0，结束节点，后续节点为0
		//
		// WfwFlow flow = wfwFlowRepository.findById(Long.parseLong(flowId));
		//
		// // 查找流程活动节点
		// List wfwActivitys = wfwActivityRepository.findByflowId(flowId);
		//
		// // 查到开始节点，前序节点为0的是开始节点
		// WfwActivity startActivity = (WfwActivity) wfwActivitys.get(0);
		//
		// // 生成进程
		// WfwProcess process = new WfwProcess();
		// process.setFlowId(flowId);
		// process.setPName(flow.getFname() + "-" + flowId);
		// process.setCreateDate(new Date());
		//
		// // 设置下一处理节点
		// WfwActivity current =
		// wfwActivityRepository.findById(Long.parseLong(startActivity.getNextActivity()));
		// // 设置当前处理节点
		// process.setCurrentActivityId(String.valueOf(current.getId()));
		//
		//
		// process.setNextActivityId(String.valueOf(current.getNextActivity()));
		// // 启动流程，
		// wfwProcessRepository.save(process);
		//
		// //设置 表单值
		// for (WfwFormFieldV object : wfwFormFieldVList) {
		wfwFormFieldRepository.updateFieldValue(WfwFormField.getId(), WfwFormField.getFieldvalue());
		// }
		//
		// // 添加当前节点的处理人
		// // addTask(String.valueOf(process.getId()));
		// // 查找当前的节点的处理人
		// List<Map<String, String>> objects =
		// wfwActivityRepository.findByUActivityId(process.getCurrentActivityId());
		//
		// //List<User> user3 =
		// wfwActivityRepository.findByUserActivityId(process.getCurrentActivityId());
		//
		// String irsStr = JSON.toJSONString(objects);
		// List<User> users = JSON.parseArray(irsStr, User.class);
		//
		// // BeanUtil.
		// // List users2 = Dozer.convert(objects, User.class);
		// // //EntityUtils.castEntity(objects, User.class, new User());
		// // 添加到任务列表
		//
		// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
		// User user = (User) iterator.next();
		// WfwTask task = new WfwTask();
		// task.setTaskName(current.getName());
		// // task.setPid(String.valueOf(process.getId()));
		// task.setPid(String.valueOf(process.getId()));
		// task.setCreateDate(new Date());
		// task.setUpdateDate(new Date());
		// task.setStatus(0);
		// task.setUserId(String.valueOf(user.getId()));
		// task.setFlowId(process.getFlowId());
		// task.setCurrentId(process.getCurrentActivityId());
		// wfwTaskRepository.save(task);
		// }

		// WfwTask task = new WfwTask();
		// task.setTaskName(process.getPName());
		// task.setPid(String.valueOf(process.getId()));
		// task.setStatus(0);
		// task.setUserId(String.valueOf(1));
		//
		// task.setFlowId(flowId);
		//
		// wfwTaskRepository.save(task);

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
		// data.setData(process);
		return data;
	}

	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping("/pay")
	@ResponseBody
	public ResultData pay(String orderSn, String status) {
		// Message message = new Message();
		// message.setId("KFK_STOCK"+System.currentTimeMillis());
		//
		// message.setMsg(order.getName());
		// message.setSendTime(new Date());
		try {
			// producer.send();
			/// redisService.set(message.getId(), message.getMsg());
			// System.err.print("send kfk express="+gson.toJson(message));
			// kafkaTemplate.send("mall", gson.toJson(message));
			// 通知支付成功
			// kafkaTemplate.send("order", gson.toJson(message));
			// 更新支付状态
			// payService.updatePayStatus(orderSn, status);
			String result;
			try {
				result = httpAPIService.doGet(
						env.getProperty("spring.bizmate.order") + "/callbackPay?orderSn=" + orderSn + "&payStatus=1");
				ResultData data = gson.fromJson(result, ResultData.class);
				// 如果回调成功
				String sucesss = (String) data.getData();
				if (PayStatus.PAYSUCESS.getValue().equalsIgnoreCase(sucesss)) {
					System.err.println("支付回调结果" + sucesss);
					// payRepository.updatePayStatus(orderSn, status);
				} else {
					new Exception("更新支付异常");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 通知待发货
			// kafkaTemplate.send("express", gson.toJson(message));
			// httpAPIService.doGet(env.getProperty("spring.bizmate.express")+"/addExpress?id="+order.getId()+"&name="+order.getName()
			// +"&money=2&fee=2");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(orderSn);
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