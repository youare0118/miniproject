package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.MemberCommand;
import miniProject.service.member.MemberAutoNumService;
import miniProject.service.member.MemberDeleteService;
import miniProject.service.member.MemberDetailService;
import miniProject.service.member.MemberInsertService;
import miniProject.service.member.MemberListService;
import miniProject.service.member.MemberUpdateService;
import miniProject.service.member.MembersDeleteService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberAutoNumService memberAutoNumService;
	@Autowired
	MemberInsertService memberInsertService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MembersDeleteService membersDeleteService;
	
	@GetMapping("memberList")
	public String memberList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			   , @RequestParam(value = "searchWord", required = false) String searchWord
			   , Model model) {
		memberListService.execute(model, page, searchWord);
	    return "thymeleaf/member/memberList";
	}
	
	@RequestMapping(value="memberRegist", method = RequestMethod.GET)
	public String memberRegist(MemberCommand memberCommand, Model model) {
		memberAutoNumService.execute(model);
	    return "thymeleaf/member/memberForm";
	}
	
	// 유효성 검사를 안할 경우 memberCommand 대신 memberDTO를 쓰기도 함
	@RequestMapping(value = "memberRegist", method = RequestMethod.POST)
	public String memberRegist(@Validated MemberCommand memberCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		if (!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		memberInsertService.execute(memberCommand);
		return "redirect:memberList";
	}

	@GetMapping("memberDetail")
	public String memberDetail(@RequestParam("memberNum") String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberInfo";
	}

	@GetMapping("memberUpdate")
	public String memberUpdate(@RequestParam("memberNum") String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberModify";
	}

	@PostMapping("memberModify")
	public String memberModify(@Validated MemberCommand memberCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberModify";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail?memberNum=" + memberCommand.getMemberNum();
	}

	// 주소 전달 방식 @PathVariable
	// member/memberDelete/mem100003 = > member/memberList : .. = 한칸 앞으로 가서 변경
	@GetMapping("memberDelete/{memberNum}")
	public String memeberDelete(@PathVariable("memberNum") String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:../memberList";
	}

	@PostMapping("membersDelete")
	public String membersDelete(@RequestParam("nums") String memberNums[]) {
		membersDeleteService.execute(memberNums);
		return "redirect:memberList";
	}
}
