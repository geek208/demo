package com.hadron.wfw.api;


import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.HttpAPIService;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.model.User;
import com.hadron.wfw.model.WfwFormField;
import com.hadron.wfw.model.WfwOrg;
import com.hadron.wfw.model.WfwOrgUser;
import com.hadron.wfw.model.WfwRole;
import com.hadron.wfw.model.WfwRoleUser;
import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.producer.Producer;
import com.hadron.wfw.service.OrgRepository;
import com.hadron.wfw.service.RoleRepository;
import com.hadron.wfw.service.UserRepository;
import com.hadron.wfw.service.WfwFlowRepository;
import com.hadron.wfw.service.WfwUserRepository;
import com.hadron.wfw.service.WfwUserService;

import java.util.List;

/**
 * User controller
 * <p/>
 * Created in 2018.11.16
 * <p/>
 *
 */
@Controller
@RequestMapping("/wfwuser")
public class WfwUserController {

    /**
     * The User service.
     */
    @Autowired
    WfwUserService userService;
    
    @Autowired
    private Producer producer;
    
    @Autowired
    private CloseableHttpClient httpClient;
    
    @Autowired
    private HttpAPIService httpAPIService;
    
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
	private OrgRepository orgRepository;
    
    @Autowired
   	private UserRepository userRepository;
    
    private static Gson gson = new GsonBuilder().create();

//    /**
//     * Index string.
//     *
//     * @return the string
//     */
//    @RequestMapping("/")
//    public String index() {
//        return "redirect:/mall/list";
//    }
//
//    /**
//     * List string.
//     *
//     * @param model the model
//     * @return the string
//     */
//    @RequestMapping("/list")
//    public String list(Model model) {
//        List<User> users = userService.getUserList();
//        model.addAttribute("users", users);
//        return "";
//        //return gson.toJson(users);
//        //return "redirect:/";
//    }
//
//    /**
//     * To add string.
//     *
//     * @return the string
//     */
//    @RequestMapping("/toAdd")
//    public String toAdd() {
//        return "user/userAdd";
//    }

   
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/createUser")
	@ResponseBody
    public ResultData createUser(WfwUser user) throws Exception {
        userService.save(user);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(user);
		return data;
     
    }
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/createRole")
	@ResponseBody
    public ResultData createRole(WfwRole role) throws Exception {
    	roleRepository.save(role);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(role);
		return data;
     
    }
    
    
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/createOrg")
	@ResponseBody
    public ResultData createOrg(WfwOrg org) throws Exception {
    	orgRepository.save(org);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(org);
		return data;
    }
    
    /**
	 * 获取表单
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	 //@RequestMapping("/getFormFields")
    
	@GetMapping("/getUserList/{id}")
	@ResponseBody
	public ResultData getUserList(@PathVariable String id ) {
		List<User> wfwUsers  = userRepository.findAll(); 

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(wfwUsers);
		return data;
	}
	
	@GetMapping("/getRoleUserList/{id}")
	@ResponseBody
	public ResultData getRoleUserList(@PathVariable String id ) {

		List<User> wfwUsers  = userRepository.findAll();
//		WfwFormV formV = new WfwFormV();
//		formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(wfwUsers);
		return data;
	}
	
	
	@GetMapping("/getRoleList/{id}")
	@ResponseBody
	public ResultData getRoleList(@PathVariable String id ) {

		List<WfwRole> roles  = roleRepository.findAll();
//		WfwFormV formV = new WfwFormV();
//		formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(roles);
		return data;
	}
	
	@GetMapping("/getOrgList/{id}")
	@ResponseBody
	public ResultData getOrgList(@PathVariable String id ) {

		List<WfwOrg> orgs  = orgRepository.findAll();
//		WfwFormV formV = new WfwFormV();
//		formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(orgs);
		return data;
	}
	
	
	
	@GetMapping("/getOrgUserList/{id}")
	@ResponseBody
	public ResultData getOrgUserList(@PathVariable String id ) {

		List<User> wfwUsers  = userRepository.findAll();
//		WfwFormV formV = new WfwFormV();
//		formV.setFormfield(formField);

		ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(wfwUsers);
		return data;
	}
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/bindOrg")
	@ResponseBody
    public ResultData bindOrg(WfwOrgUser orgUser) throws Exception {
    	orgRepository.save(orgUser);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(orgUser);
		return data;
    }
    
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/bindRole")
	@ResponseBody
    public ResultData bindRole(WfwRoleUser roleUser) throws Exception {
    	roleRepository.save(roleUser);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(roleUser);
		return data;
    }

//    /**
//     * To edit string.
//     *
//     * @param model the model
//     * @param id    the id
//     * @return the string
//     */
//    @RequestMapping("/toEdit")
//    public String toEdit(Model model, Long id) {
//        User user = userService.findUserById(id);
//        model.addAttribute("user", user);
//        return "user/userEdit";
//    }
//
//    /**
//     * Edit string.
//     *
//     * @param user the user
//     * @return the string
//     */
//    @RequestMapping("/edit")
//    public String edit(User user) {
//        userService.edit(user);
//        return "redirect:/list";
//    }
//
//
//    /**
//     * Delete string.
//     *
//     * @param id the id
//     * @return the string
//     */
//    @RequestMapping("/delete")
//    public String delete(Long id) {
//        userService.delete(id);
//        return "redirect:/list";
//    }
}