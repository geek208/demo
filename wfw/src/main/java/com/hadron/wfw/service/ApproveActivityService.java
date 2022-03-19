package com.hadron.wfw.service;




import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hadron.wfw.ApprovalType;
import com.hadron.wfw.OwerType;
import com.hadron.wfw.model.Activity;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwLink;
import com.hadron.wfw.model.WfwProcess;
import com.hadron.wfw.model.WfwTask;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ApproveActivityService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Service
public class  ApproveActivityService implements ActivityService{
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
	
//	@Autowired
//	WfwActivityService wfwActivityService;
	
    
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
	private OrgRepository orgRepository;
    
    
    @Autowired
	private WfwUserRepository userRepository;
    
	@Override
	public void callBack(WfwUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prePost(WfwUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WfwActivity addActivity(WfwActivity activity) {
		activity.setCreateDate(new Date());
		activity.setUpdateDate(new Date());
		//默认为或签
		activity.setApproveType(ApprovalType.OR.getValue());
		//默认按人
		activity.setUserType(OwerType.USER.getValue());

		WfwActivity endact = wfwActivityRepository.findEndByflowId(activity.getFlowId());
		// 新加节点的后续为 ”结束“
		if (endact != null) {
			activity.setNextActivity(String.valueOf(endact.getId()));
			wfwActivityRepository.save(activity);
		}
		// 更新前序节点的 后续节点
		WfwActivity pre = wfwActivityRepository.findById(Long.parseLong(activity.getPreActivity()));
		pre.setNextActivity(String.valueOf(activity.getId()));
		//
		// activity.getId()
		// 修改前序的后续节点
		wfwActivityRepository.save(pre);
		
		//加连接线
		this.addLink(activity);
		
		return activity;
	}

	@Override
	public void bindUser(WfwUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTask(WfwUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dotask(String taskId) {

		// 查看当前任务
		WfwTask task = wfwTaskRepository.findById(Long.parseLong(taskId));
		
		// wfwProcessRepository.
		// 更新为已处理
		wfwTaskRepository.updateTaskStatus(taskId, "1","处理意见");
		
		// 查看当前进程
		WfwProcess process = wfwProcessRepository.findById(Long.parseLong(task.getPid()));
		
		WfwActivity current = wfwActivityRepository.findById(Long.parseLong(process.getNextActivityId()));
		//查找当前节点，判定审批类别 0，或签 ，1 ，会签 2，依次审批
		if(ApprovalType.OR.getValue().equals(current.getApproveType())){
			
			System.err.println("或签="+current.getApproveType());
			// 修改当前节点，为审批2
			process.setCurrentActivityId(process.getNextActivityId());
			//
			// 查找审批2
			WfwActivity next = wfwActivityRepository.findById(Long.parseLong(process.getNextActivityId()));
			// 修改下一个节点为审批2的下一个节点
			if (next != null && next.getNextActivity() != null) {
				process.setNextActivityId(next.getNextActivity());
				//
			} else {
				 
				// 如果后续审批2的后续为空 ，则修改当前节点为结束
				// process.setCurrentActivityId("1");

				process.setNextActivityId("0");
			}
			wfwProcessRepository.save(process);
		

			// 更新任务处理状态为已处理，
			// 查找当前的节点的处理人，增加下一个节点的处理人
			if (next != null) {
				List<Map<String, String>> objects = wfwActivityRepository.findByUActivityId(String.valueOf(next.getId()));
				String irsStr = JSON.toJSONString(objects);
				List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);
				for (Iterator iterator = users.iterator(); iterator.hasNext();) {
					WfwUser user = (WfwUser) iterator.next();
					WfwTask task2 = new WfwTask();
					task2.setTaskName(next.getName());
					// task.setPid(String.valueOf(process.getId()));
					task2.setPid(String.valueOf(process.getId()));
					task2.setCreateDate(new Date());
					task2.setUpdateDate(new Date());
					task2.setCurrentId(String.valueOf(next.getId()));
					// 待处理
					task2.setStatus(0);
					task2.setUserId(String.valueOf(user.getId()));
					task2.setFlowId(process.getFlowId());
					wfwTaskRepository.save(task2);
				}
			}
			
		} else if(ApprovalType.AND.getValue().equals(current.getApproveType())){
			//查找本地节点待处理人数
			//查找已经处理的人数
			//如果已处理人数 等于待处理人数
			//本节点所有人已经处理完
			System.err.println("会签="+current.getApproveType());
			
			 int list = wfwTaskRepository.findTaskNotFinish(String.valueOf(process.getId()), process.getCurrentActivityId());
			
			
			//未全部处理
			if(list >0){
				
				return 0;
//				ResultData data = new ResultData();
//				data.setCode(200);
//				data.setSuccess(true);
//				data.setMessage("成功");
//				data.setData(process);
//				return data; 
				
				//走下一个节点
			}else{
				// 修改当前节点，为审批2
				process.setCurrentActivityId(process.getNextActivityId());
				//
				// 查找审批2
				WfwActivity next = wfwActivityRepository.findById(Long.parseLong(process.getNextActivityId()));
				// 修改下一个节点为审批2的下一个节点
				if (next != null && next.getNextActivity() != null) {
					process.setNextActivityId(next.getNextActivity());
					//
				} else {
					 
					// 如果后续审批2的后续为空 ，则修改当前节点为结束
					// process.setCurrentActivityId("1");

					process.setNextActivityId("0");
				}
				wfwProcessRepository.save(process);

				// 更新任务处理状态为已处理，
				// 查找当前的节点的处理人，增加下一个节点的处理人
				if (next != null) {
					List<Map<String, String>> objects = wfwActivityRepository.findByUActivityId(String.valueOf(next.getId()));
					String irsStr = JSON.toJSONString(objects);
					List<WfwUser> users = JSON.parseArray(irsStr, WfwUser.class);
					for (Iterator iterator = users.iterator(); iterator.hasNext();) {
						WfwUser user = (WfwUser) iterator.next();
						WfwTask task2 = new WfwTask();
						task2.setTaskName(next.getName());
						// task.setPid(String.valueOf(process.getId()));
						task2.setPid(String.valueOf(process.getId()));
						task2.setCreateDate(new Date());
						task2.setUpdateDate(new Date());
						task2.setCurrentId(String.valueOf(next.getId()));
						// 待处理
						task2.setStatus(0);
						task2.setUserId(String.valueOf(user.getId()));
						task2.setFlowId(process.getFlowId());
						wfwTaskRepository.save(task2);
					}
				}
			}
			
			System.err.println("会签 完成="+current.getApproveType());
			
		}
	return 1;
	}

	@Override
	public void addLink(WfwActivity activity) {
		
		WfwLink link  = new WfwLink();
		link.setPreId(activity.getPreActivity());
		link.setNextId(String.valueOf(activity.getId()));
		
		wfwActivityRepository.save(link);	
	}
}
