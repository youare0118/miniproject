package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.LoginCommand;
import miniProject.service.login.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UserLoginService userLoginService;
	
	@GetMapping("login")
	public String login() {
		return "thymeleaf/login/login";
	}
	
	//이게 원본의 login이랑 같다고 생각하면됨
	@PostMapping("loginCheck")
	public String loginCheck(@Validated LoginCommand loginCommand, BindingResult result
			,@RequestParam(value="page", required = false , defaultValue = "1") Integer page 
			,Model model, HttpSession session) {
		userLoginService.execute(loginCommand, session, result);
		if(result.hasErrors()) {
			return "thymeleaf/login/login";
		}
		return "redirect:/";
	}
	
	@GetMapping("loginAgree")
	public String agree() {
		return "thymeleaf/login/loginAgree";
	}
}
