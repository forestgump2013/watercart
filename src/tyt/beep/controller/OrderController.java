package tyt.beep.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tyt.beep.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/create.do")
	public void createOrder(){
		System.out.println("create order ..");
	}
	
	@RequestMapping(value="/login.do",produces="")
	@ResponseBody
	public String login(HttpServletRequest request){
		String openid=request.getParameter("openid");
		System.out.println("openid:"+openid);
		return orderService.login(openid);
		
	}
	
	@RequestMapping(value="/addorder.do",method=RequestMethod.POST)
	@ResponseBody
	public String addOrder(HttpServletRequest request){
		
		int address_id= Integer.parseInt( request.getParameter("address_id"));
		String content=request.getParameter("content");
		System.out.println("address_id:"+address_id);
		int cnt= orderService.addOrder(address_id, content);
		
		return "success:"+cnt;
	}
	
	

}
