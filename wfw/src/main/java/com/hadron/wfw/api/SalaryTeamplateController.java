package com.hadron.wfw.api;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.CalculationUtil;
import com.hadron.wfw.GetPayNo;
import com.hadron.wfw.HttpAPIService;
import com.hadron.wfw.PayStatus;
import com.hadron.wfw.RedisService;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.SalaryPhase;
import com.hadron.wfw.SalaryType;
import com.hadron.wfw.SourceType;
import com.hadron.wfw.model.EasyPay;
import com.hadron.wfw.model.SalaryGroup;
import com.hadron.wfw.model.SalaryItem;
import com.hadron.wfw.model.SalaryProcess;
import com.hadron.wfw.model.SalaryTemplate;
import com.hadron.wfw.model.SalaryUser;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityRules;
import com.hadron.wfw.model.WfwFlow;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.WfwProcess;
import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.producer.Producer;
import com.hadron.wfw.service.EasyPayService;
import com.hadron.wfw.service.SalaryGroupRepository;
import com.hadron.wfw.service.SalaryItemRepository;
import com.hadron.wfw.service.SalaryProcessRepository;
import com.hadron.wfw.service.SalaryTemplateRepository;
import com.hadron.wfw.service.UserFieldRepository;
import com.hadron.wfw.service.UserRepository;
import com.hadron.wfw.service.WfwUserRepository;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import io.swagger.annotations.ApiOperation;

/**
 * User controller
 * <p/>
 * Created in 2018.11.16
 * <p/>
 *
 */
@Controller
@RequestMapping("/salary")
public class SalaryTeamplateController {

    /**
     * The User service.
     */
    @Autowired
    EasyPayService payService;
    @Autowired
    private HttpAPIService httpAPIService;
    @Autowired
    private Producer producer;
    @Autowired
    private KafkaTemplate kafkaTemplate;
	@Autowired
	private RedisService redisService;
	
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    SalaryProcessRepository salaryProcessRepository;
    
    @Autowired
    SalaryItemRepository salaryItemRepository;
    
    @Autowired
    SalaryTemplateRepository salaryTemplateRepository;
    
    @Autowired
    SalaryGroupRepository salaryGroupRepository;
    
    @Autowired
   	private UserFieldRepository userFieldRepository;
 
    
    @Autowired
   	private WfwUserRepository wfwUserRepository;
    
	@Autowired
	private Environment env;
	
    private static Gson gson = new GsonBuilder().create();
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/createTemp")
    @ResponseBody
    public ResultData createTemp(SalaryTemplate pay) {
        salaryTemplateRepository.save(pay);
        ResultData data =new ResultData();
        data.setCode(200);
        data.setSuccess(true);
        data.setMessage("成功");
        data.setData(pay);
        return data;
    }
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/createItem")
    @ResponseBody
    public ResultData createItem(SalaryItem pay) {
        salaryItemRepository.save(pay);
        ResultData data =new ResultData();
        data.setCode(200);
        data.setSuccess(true);
        data.setMessage("成功");
        data.setData(pay);
        return data;
    }
    
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/createSalrayUser")
    @ResponseBody
    public ResultData createSalrayUser(SalaryUser pay) {
    	salaryTemplateRepository.save(pay);
        ResultData data =new ResultData();
        data.setCode(200);
        data.setSuccess(true);
        data.setMessage("成功");
        data.setData(pay);
        return data;
    }
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/createSalrayGroup")
    @ResponseBody
    public ResultData createSalrayGroup(SalaryGroup pay) {
    	salaryGroupRepository.save(pay);
        ResultData data =new ResultData();
        data.setCode(200);
        data.setSuccess(true);
        data.setMessage("成功");
        data.setData(pay);
        return data;
    }
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/pay")
    @ResponseBody
    public ResultData  start(String templateId) {
    	
    	
    	//获取模板字段
    	//根据类别，分别获取数据
    	
    	//把模板字段快照一份
    	
    	//解释字段规则
    	
    	//从人事档案获取
    	
    	//fill 进字段表


        ResultData data =new ResultData();
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
	 * @throws Exception
	 */
	@GetMapping("/getTemplateList/{id}")
	@ResponseBody
	public ResultData getTemplateList(@PathVariable String id) throws Exception {

		List<SalaryTemplate> flows = salaryTemplateRepository.findAll();

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
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 * @throws Exception
	 */
	@GetMapping("/getSalaryItemList/{id}")
	@ResponseBody
	// @CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,
	// RequestMethod.POST})
	public ResultData getSalaryItemList(@PathVariable String id) throws Exception {

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(salaryItemRepository.findByTempId(id));
		
		return data;
	}
	
	/**
	 * Add string.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 * @throws Exception
	 */
	@GetMapping("/getSalaryColumnList/{id}")
	@ResponseBody
	// @CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,
	// RequestMethod.POST})
	public ResultData getSalaryColumnList(@PathVariable String id) throws Exception {

		List <UserField>  fields = userFieldRepository.findByGroupId(id);
		
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(fields);
		
		return data;
	}
	
	
	@GetMapping("/getSalaryItem/{id}")
	@ResponseBody
	// @CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,
	// RequestMethod.POST})
	public ResultData getSalaryItem(@PathVariable String id) throws Exception {
		
		SalaryItem salaryItem= salaryItemRepository.findById(Long.parseLong(id));
		List <UserField>  fields = userFieldRepository.findByGroupId("4");
		StringBuffer sb =new StringBuffer();
		
		for (UserField userField : fields) {
			sb.append(userField.getName()+";");
		}
		
		
		salaryItem.setReffieldColumn(sb.toString());
		
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(salaryItem);
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

		SalaryTemplate template = salaryTemplateRepository.findById(Long.parseLong(id));
		// 生成进程
		SalaryProcess process = new SalaryProcess();
		process.setTempalteName(template.getTempalteName());
		process.setTemplateId(String.valueOf(template.getId()));

		//设置处理阶段
		process.setPhase(SalaryPhase.BRFORETAX.getValue());
		process.setCpyId(template.getCpyId());
		process.setCircle(template.getCircle());
		
		//获取算薪人员
		List<Map<String, String>> obj = wfwUserRepository.findByTemplateId(String.valueOf(template.getId()));
		String irs= JSON.toJSONString(obj);
		List<WfwUser> users = JSON.parseArray(irs, WfwUser.class);
		
		System.err.println("找到需要算薪的人员=" + users.size());
		
		

		// 启动流程，
		salaryProcessRepository.save(process);

		// 查找模板所有薪资项
		List<SalaryItem> wfwFormFields = salaryItemRepository.findByTempId(id);

		System.err.println("生成进程的薪资字段快照,每个进程生成一份    薪资字段=" + wfwFormFields.size());

		// 生成进程的表单快照,每个进程生成一份
		List<SalaryItem> newwfwFormFields = new ArrayList();
		
		if(users !=null&& users.size()>0 && wfwFormFields !=null){
			
			for (SalaryItem object : wfwFormFields) {

				//每个人 计算生成一份
				for (WfwUser user : users) {
					// object.setUserId(userId);
					SalaryItem field = new SalaryItem();
					field.setFieldName(object.getFieldName());
					field.setFieldType(object.getFieldType());
					field.setGroupId(object.getGroupId());
					field.setRules(object.getRules());
					field.setRulesType(object.getRulesType());
					// 绑定本进程
					field.setPId(String.valueOf(process.getId()));
					// field.setActivityId(object.getActivityId());
					field.setParentId(String.valueOf(object.getId()));
					field.setUserId(String.valueOf(user.getId()));
					//导入
					if(SalaryType.QUOTE.getValue().equals(object.getRulesType())){
						System.err.print("数据来源      数据导入=" + object.getRulesType());
						String rule  = object.getRules();
						//如果是薪资档案
						if(SourceType.BASE.getValue().equals(object.getReffieldTable())){
							
							System.err.println("数据来源  薪资档案【" + object.getReffieldTable()+"]");
							    object.getReffieldColumn();
							    //获取基本薪资数据
							    UserField userfield = userFieldRepository.findByNameId(object.getReffieldColumn(),String.valueOf(user.getId()));

							    if(userfield !=null){
							     System.err.println("数据来源  userfield【" + userfield.getFieldvalue()+"]");
							    	field.setFieldValue(userfield.getFieldvalue());
							    	field.setFieldName(userfield.getCnName());
							    	field.setReffieldTable(object.getReffieldTable());
							    }
							    
							    
						//专项扣除    
						}else if(SourceType.DEDUCT.getValue().equals(object.getReffieldTable())){
							    System.err.println("数据来源  专项扣除【" + object.getReffieldTable()+"]");
							    
							    UserField userfield = userFieldRepository.findByNameId(object.getReffieldColumn(),String.valueOf(user.getId()));;
						}
						
						//如果是计算公式
					}else if (SalaryType.CALCULATE.getValue().equals(object.getRulesType())){
						System.err.println("数据来源      自定义计算公式=" + object.getRulesType());
						//如果是薪资档案
						if(SourceType.BASE.getValue().equals(object.getReffieldTable())){
							    object.getReffieldColumn();

							    String val =  object.getReffieldColumn();
								String [] aa1 = val.split("&");
								//去掉转义符号
								String newstr = val.replace("&", "");
								ExpressRunner runner = new ExpressRunner(false, false);
								DefaultContext<String, Object> context = new DefaultContext<String, Object>();
								
								for (String string : aa1) {
									//System.out.println(string+"===="+CalculationUtil.isNumericZidai(string));
									//如果是Id
									if(CalculationUtil.check(string)){
										//获取基本薪资数据
									    UserField userfield = userFieldRepository.findByName(string);
									    
										context.put(string, new BigDecimal(userfield.getFieldvalue()));
										//context.put("c", new BigDecimal("0.15384615384615385"));
										//context.put("d", new BigDecimal("1"));
									}
									Object r = null;
									try {
										r = runner.execute(newstr, context, null, false, false);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									//设置计算结果
									field.setFieldValue(r.toString());
									//
								}
						//专项扣除    
						}else if(SourceType.DEDUCT.getValue().equals(object.getReffieldTable())){
							    //UserField userfield = userFieldRepository.findById(Long.parseLong(object.getReffieldColumn()));
						}
					}
					
					salaryItemRepository.save(field);

					newwfwFormFields.add(field);
				}
				

			}
		}
		//
		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(newwfwFormFields);
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/updateSalaryItem")
	public ResultData updateSalaryItem(@RequestBody SalaryItem message) {
		// addOrUpdate(message);
		// 查找表单所有字段
		/// List<WfwFormField> wfwFormFields =
		// wfwFormFieldRepository.findByflowId(id);

		salaryItemRepository.save(message);

		// 绑定规则字段到活动上
		// UPDATE t_wfw_form_field SET activity_id =?,rules =? WHERE id =?

		System.err.println(message.getId() + "  field " + message.getId() + "  rules " + message.getRules());

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(message);
		return data;

	}
}