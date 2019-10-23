package prof.leu.shiro1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import prof.leu.shiro1.service.UserService;

@Controller
public class UserController {



	@ResponseBody
	@RequestMapping("hello")
	public  String hello() {
		System.out.println();
		return "PL" ;
	}
	
	
	@RequestMapping("/page1")
	public  String page1(Model model) {
		model.addAttribute("name" ,"送达方式地方");
		return "page-1" ;
	}
	@RequestMapping("/user/add")
	public  String add(Model model) {
		model.addAttribute("name" ,"送达方式地方");
		return "user/add" ;
	}
	
	@RequestMapping("/user/update")
	public  String update(Model model) {
		model.addAttribute("name" ,"送达方式地方");
		return "user/update" ;
	}
	@RequestMapping("/login")
	public  String login(Model model) {
		model.addAttribute("name" ,"送达方式地方");
		return "login" ;
	}
	@RequestMapping("/login_post")
	public  String login_post(String name,String password,Model model) {

		Subject subject = SecurityUtils.getSubject() ;
		UsernamePasswordToken token = new UsernamePasswordToken(name,password) ;
		try {
			subject.login(token);
			return "redirect:/page1" ;
		} catch (UnknownAccountException e) {
//			e.printStackTrace();
			model.addAttribute("msg" ,"用户名不存在");
			return "/login" ;
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg" ,"密码不正确");
			return "/login" ;
		}catch (AuthenticationException e){
			model.addAttribute("msg" ,"认证没通过");
			e.printStackTrace();
			return "/login" ;
		}



	}
}
