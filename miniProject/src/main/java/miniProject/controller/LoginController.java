package miniProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.LoginCommand;
import miniProject.command.MemberCommand;
import miniProject.service.login.MemberWriteService;
import miniProject.service.login.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UserLoginService userLoginService;
	@Autowired
	MemberWriteService memberWriteService;
	
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
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="userForm", method = RequestMethod.GET)
	public String userForm(MemberCommand memberCommand) {
		return "thymeleaf/login/userForm";
	}
	
	@PostMapping("userRegist")
	public String userRegist(@Validated MemberCommand memberCommand, BindingResult result,
			Model model) {
		// 오류가 있는 경우 오류 메시지가 출력되게 한다.
		if(result.hasErrors()) {
			return "thymeleaf/login/userForm";
		}
		memberWriteService.execute(memberCommand, model);//  정상적으로 저장이 되었다.
		return "thymeleaf/login/welcome";
	}
}
