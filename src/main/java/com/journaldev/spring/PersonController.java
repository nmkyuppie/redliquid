package com.journaldev.spring;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Pincode;
import com.journaldev.spring.model.Register;
import com.journaldev.spring.model.Request;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.PincodeService;
import com.journaldev.spring.service.RequestService;
import com.journaldev.spring.service.UserService;

@Controller
public class PersonController {

	private PersonService personService;
	private UserService userService;
	private PincodeService pincodeService;
	private RequestService requestService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService personService){
		this.personService = personService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="pincodeService")
	public void setPincodeService(PincodeService pincodeService){
		this.pincodeService = pincodeService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="requestService")
	public void setRequestService(RequestService requestService){
		this.requestService = requestService;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value = "/p", method = RequestMethod.GET)
	public String listPersonsa(Model model) {
		model.addAttribute("hi", "da");
		return "test";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    @RequestMapping(value= "/login",method = RequestMethod.GET)
    public String viewLogin(@ModelAttribute("login") User ud){
    	return "login";
    }
	
    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public String validateLogin(@ModelAttribute("login") User ud,
            ModelMap model,HttpServletResponse response) throws Exception{
    	
    	String key = "Redff0000Liquid!";
    	String returnString="login";
    	
    		if(this.userService.validate(ud)){
    			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    			Cipher cipher = Cipher.getInstance("AES");
    			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
    			byte[] encrypted = cipher.doFinal(ud.getUsername().getBytes());
    			System.err.println(new String(encrypted));
    			cipher.init(Cipher.DECRYPT_MODE, aesKey);
    			String decrypted = new String(cipher.doFinal(encrypted));
    			System.err.println(decrypted);
    			
    			User u=this.userService.getUserDetail(ud.getUsername());
    			
    			Cookie cookie = new Cookie("redliquid_username", u.getUsername());
    			response.addCookie(cookie);
    			returnString="empty";
        		model.addAttribute("sucessMsg", "Successfully logged in");

        		model.addAttribute("listusers", this.userService.listUsers());
//        		model.addAttribute("user", new User());
//        		model.addAttribute("listusers", this.userService.listUsers().get("usersList"));
        		model.addAttribute("totalcount", this.userService.listUsers().get("totalCount"));
    		}
    		else{
        		model.addAttribute("sucessMsg", "Login failed");
    		}
    		

    	return returnString;
    }
    

	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String viewRegister(Model model, Register r) {
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("register") User u, ModelMap model){
		this.userService.addUser(u);
		model.addAttribute("listusers", this.userService.listUsers());
		model.addAttribute("totalcount", this.userService.listUsers().get("totalCount"));
		return "search";
	}
	
	@RequestMapping(value="/state",method=RequestMethod.POST)
	public @ResponseBody String getState(){
		String[] statesString={"ANDHRA PRADESH","ARUNACHAL PRADESH","ASSAM","BIHAR","CHANDIGARH","CHATTISGARH","DELHI","GUJARAT","HARYANA"
				,"HIMACHAL PRADESH","JAMMU & KASHMIR","JHARKHAND","KARNATAKA","KERALA","MADHYA PRADESH","MAHARASHTRA","MANIPUR","MEGHALAYA","MIZORAM","NAGALAND","ORISSA"
				,"PUNJAB","RAJASTHAN","SIKKIM","TAMIL NADU","TRIPURA","UTTAR PRADESH","UTTARAKHAND","WEST BENGAL"};
		List<String> states=new ArrayList<String>();
		for(String s: statesString){
			states.add(s);
		}
		return states.toString();
	}
	
	@RequestMapping(value="/district",method=RequestMethod.POST)
	public @ResponseBody String getDistrict(@RequestParam(value="state", required=false) String state){
		List<Pincode> districtList=this.pincodeService.getDistrict(state.trim());
		return districtList.toString();
	}
	
	@RequestMapping(value="/taluk",method=RequestMethod.POST)
	public @ResponseBody String getTaluk(@RequestParam(value="district", required=false) String district){
		System.out.println("district :: " +district);
		List<Pincode> cityList=this.pincodeService.getCity(district.trim());
		return cityList.toString();
	}
    
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public String viewSearch(Model model, User u) {
		model.addAttribute("listusers", this.userService.listUsers());
//		model.addAttribute("user", new User());
//		model.addAttribute("listusers", this.userService.listUsers().get("usersList"));
		model.addAttribute("totalcount", this.userService.listUsers().get("totalCount"));
		return "search";
	}
    
	@RequestMapping(value = "/searchByCriteria",method = RequestMethod.GET)
	public String searchByCriteria(
			Model model,
			@RequestParam(value="bloodGroup",required=false,defaultValue="-1") String  bloodGroup,
			@RequestParam(value="stateName",required=false,defaultValue="-1") String stateName,
			@RequestParam(value="districtName",required=false,defaultValue="-1") String districtName,
			@RequestParam(value="cityName",required=false,defaultValue="-1") String cityName,
			@RequestParam(value="pageNo",required=false,defaultValue="1") String pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="10") String pageSize,
			User u) {
		pageSize="10";
		model.addAttribute("listusers", this.userService.getSearchList(bloodGroup.trim(),stateName.trim(),districtName.trim(),cityName.trim(),pageNo,pageSize));
		return "searchData";
	}
    
	@RequestMapping(value = "/getTotalCount",method = RequestMethod.GET)
	@ResponseBody
	public String getTotalSearchCount(
			@RequestParam(value="bloodGroup",required=false,defaultValue="-1") String  bloodGroup,
			@RequestParam(value="stateName",required=false,defaultValue="-1") String stateName,
			@RequestParam(value="districtName",required=false,defaultValue="-1") String districtName,
			@RequestParam(value="cityName",required=false,defaultValue="-1") String cityName,
			@RequestParam(value="pageNo",required=false,defaultValue="1") String pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="10") String pageSize) {
		
		return ""+this.userService.getTotalCount(bloodGroup.trim(),stateName.trim(),districtName.trim(),cityName.trim(),pageNo,pageSize);
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String getSearchResult(@ModelAttribute("user") User u, ModelMap model){
//		model.addAttribute("user", new User());
//		model.addAttribute("listusers", this.userService.search(u).get("usersList"));
//		model.addAttribute("totalcount", this.userService.search(u).get("totalCount"));
		return "search";
	}
    

	@RequestMapping(value = "/request",method = RequestMethod.GET)
	public String viewRequest(Model model, Request r) {
		return "request";
	}
	
	@RequestMapping(value="/request",method=RequestMethod.POST)
	public String storeRequest(@ModelAttribute("request") Request r, ModelMap model){
		this.requestService.addRequest(r);
		return "request";
	}
    

	@RequestMapping(value = "/requests",method = RequestMethod.GET)
	public String showRequests(Model model, Request r) {
		return "requests";
	}
    
	@RequestMapping(value = "/requestsByCriteria",method = RequestMethod.GET)
	public String requestsByCriteria(
			Model model,
			@RequestParam(value="bloodGroup",required=false,defaultValue="-1") String  bloodGroup,
			@RequestParam(value="stateName",required=false,defaultValue="-1") String stateName,
			@RequestParam(value="districtName",required=false,defaultValue="-1") String districtName,
			@RequestParam(value="cityName",required=false,defaultValue="-1") String cityName,
			@RequestParam(value="pageNo",required=false,defaultValue="1") String pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="10") String pageSize,
			User u) {
		pageSize="10";
		model.addAttribute("listrequests", this.requestService.getRequestsList(bloodGroup.trim(),stateName.trim(),districtName.trim(),cityName.trim(),pageNo,pageSize));
		return "requestsData";
	}
    

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String viewHome(Model model, Request r,HttpServletResponse response) {
		model.addAttribute("request", new Request());
		Cookie cookie = new Cookie("hitCounter", "Hi");
		response.addCookie(cookie);
		model.addAttribute("listrequests", this.requestService.listRequests());
		return "home";
	}
    
/*	
    
    @RequestMapping(value= "/login",method = RequestMethod.GET)
    public String checkLogin(@ModelAttribute("login") UserDetails ud,
            Map<String, Object> model){
//    	model.addAttribute("Hi", ud.getUserName());
    	System.out.println("First"+ud.getUserName());
    	return "login";
    }
	
    
    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public String checkLogin1(@ModelAttribute("login") UserDetails ud,
            Map<String, Object> model){
//    	model.addAttribute("Hi", ud.getUserName());
    	System.out.println(""+ud.getUserName());
    	return "login";
    }*/
}
