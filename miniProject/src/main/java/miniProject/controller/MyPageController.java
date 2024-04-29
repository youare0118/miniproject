package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import miniProject.command.MemberCommand;
import miniProject.command.UserPwCommand;
import miniProject.service.myPage.MemberAccountService;
import miniProject.service.myPage.MemberDropService;
import miniProject.service.myPage.MemberInfoService;
import miniProject.service.myPage.UserPasswordConfirmService;

@Controller
@RequestMapping("myPage")
public class MyPageController {

	@Autowired
	MemberInfoService memberInfoService;
	@GetMapping("myPageDefalt")
	public String myPageDefalt(HttpSession session, Model model) {
		memberInfoService.execute(session, model);
		return "thymeleaf/myPage/myPageDefalt";
	}
	
	// 정보수정 페이지에서 정보 수정 버튼 누르면 나오는 페이지 = 정보 수정
	@GetMapping("myPageUpdate")
	public String myPageUpdate(@RequestParam("memberNum") String memberNum, HttpSession session, Model model) {
		memberInfoService.execute(session, model);
		return "thymeleaf/myPage/myPageModify";
	}
	
	@Autowired
	MemberAccountService memberAccountService;
	// 수정 완료 버튼 클릭 시
	@PostMapping("myPageModify")
	public String myPageModify(@Validated MemberCommand memberCommand, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "thymeleaf/myPage/myPageModify";
		}else {
			int i = memberAccountService.execute(memberCommand, session, model);
			if(i == 1) {
				return "redirect:myPageDefalt";
			}else {
				model.addAttribute("errPw", "비밀번호가 틀렸습니다.");
				return "thymeleaf/myPage/myPageModify";
			}
		}
		
	}
	
	// 회원탈퇴
	@GetMapping("myPageDrop")
	public String myPageDrop() {
		return "thymeleaf/myPage/myPageDrop";
	}
	
	@Autowired
	MemberDropService memberDropService;
	@PostMapping("myPageDropOk")
	public String postMethodName(@RequestParam String memberPw, HttpSession session, Model model) {
		int i = memberDropService.execute(memberPw, session);
		if(i == 1) {
			return "redirect:/login/logout";
		}else {
			model.addAttribute("errPw", "비밀번호가 틀렸습니다.");
			return "thymeleaf/myPage/myPageDrop";
		}
	}
	
	@Autowired
	UserPasswordConfirmService userPasswordConfirmService;
	@PostMapping("myPwUpdate") // json으로 전송된 값은 @RequestBody로 받는다.
	@ResponseBody
	public boolean myPwUpdate(@RequestBody UserPwCommand userPwCommand
			,HttpSession session) {
		return userPasswordConfirmService.execute(userPwCommand, session);
	}
	
	@GetMapping("myPageNewPw")
	public String myPageNewPw() {
		return "thymeleaf/myPage/myPageNewPw";
	}
	
	@GetMapping("myPageReserve")
	public String myPageReserve() {
		return "thymeleaf/myPage/myPageReserve";
	}
	
	@GetMapping("myPageWish")
	public String myPageWish() {
		return "thymeleaf/myPage/myPageWish";
	}
}
