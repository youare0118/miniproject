package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("myPage")
public class MyPageController {

	@GetMapping("myPageDefalt")
	public String myPageDefalt() {
		return "thymeleaf/myPage/myPageDefalt";
	}
	
	@GetMapping("myPageDrop")
	public String myPageDrop() {
		return "thymeleaf/myPage/myPageDrop";
	}
	
	@GetMapping("myPageModify")
	public String myPageModify() {
		return "thymeleaf/myPage/myPageModify";
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
