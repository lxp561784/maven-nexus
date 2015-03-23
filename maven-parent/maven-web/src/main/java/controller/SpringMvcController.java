package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user/*")
public class SpringMvcController {
	
	//重定向视图
	
	@RequestMapping("login.do")
	public ModelAndView login(Model model){
		
		return new ModelAndView("redirect:../jsp/loginSuccess.jsp");
	}
	
	@RequestMapping("login1.do")
	public String login1(Model model){
		
		return "loginSuccess";
	}
}
