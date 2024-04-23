package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@GetMapping("login")
	public String login() {
		return "thymeleaf/login/login";
	}
	@PostMapping("loginCheck")
	public String loginCheck(HttpSession session) {
		return "redirect:/";
	}
	@GetMapping("loginAgree")
	public String agree() {
		return "thymeleaf/login/loginAgree";
	}
}
