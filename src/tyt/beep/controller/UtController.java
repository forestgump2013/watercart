package tyt.beep.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.servlet.ModelAndView;


@Controller
public class UtController {
	
	@RequestMapping("/signup.do")
	public ModelAndView signup(HttpServletRequest req){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
		
	}
	
	
	@RequestMapping("/test.do")
	public void doTest(){
		System.out.println("test");
	}
}
