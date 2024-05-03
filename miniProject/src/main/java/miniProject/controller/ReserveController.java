package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.HospitalCommand;
import miniProject.command.MemberCommand;
import miniProject.command.ReserveCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.service.member.MemberDetailService;
import miniProject.service.myPage.MemberInfoService;
import miniProject.service.reserve.HospitalInfoService;
import miniProject.service.reserve.ReserveAutoNumService;
import miniProject.service.reserve.ReserveInsertService;
import miniProject.service.reserve.TreatTimeSetService;

@Controller
@RequestMapping("reserve")
public class ReserveController {

	@Autowired
	HospitalInfoService hospitalInfoService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	ReserveInsertService reserveInsertService;
	@Autowired
	ReserveAutoNumService reserveAutoNumService;
	@Autowired
	TreatTimeSetService treatTimeSetService;
	
	@GetMapping("reservation/{hospitalNum}")
	public String reservationPage(@PathVariable("hospitalNum") String hospitalNum, HttpSession session, Model model){
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth == null) {
			return "thymeleaf/login/login";
		}
		reserveAutoNumService.execute(model);
		hospitalInfoService.execute(hospitalNum, model);
		memberInfoService.execute(session, model);
		treatTimeSetService.execute(hospitalNum, model);
		return "thymeleaf/reserve/reservationPage";
	}
	@PostMapping("reservation/reserveCommit")
	public String reserveCommit(ReserveCommand reserveCommand, HospitalCommand hospitalCommand, 
								MemberCommand memberCommand, Model model, HttpSession session) {
		reserveInsertService.execute(reserveCommand, hospitalCommand, memberCommand, model);
		return "thymeleaf/reserve/reserveCommit";
	}
}
