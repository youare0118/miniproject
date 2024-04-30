package miniProject.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.HospitalCommand;
import miniProject.command.TreatCommand;
import miniProject.service.hospital.HospitalAutoNumService;
import miniProject.service.hospital.HospitalDetailService;
import miniProject.service.hospital.HospitalInsertService;
import miniProject.service.treat.TreatInsertService;

@Controller
@RequestMapping("medicalUser")
public class medicalUserController {
	@Autowired
	HospitalAutoNumService hospitalAutoNumService;
	@Autowired
	HospitalInsertService hospitalInsertService;
	@Autowired
	HospitalDetailService hospitalDetailService;
	@Autowired
	TreatInsertService treatInsertService;
	
	
	@GetMapping("userWrite")
	public String userWrite(HospitalCommand hospitalCommand, Model model) {
		hospitalAutoNumService.execute(model);
		return "thymeleaf/medicalUser/medicalForm";
	}
	@PostMapping("hospitalSubmit")
	public String myPage(HospitalCommand hospitalCommand, HttpSession session,Model model) {
		hospitalInsertService.execute(hospitalCommand, model);
		
		return "thymeleaf/medicalUser/treatForm";
	}
	@GetMapping("hospitalMyPage")
	public String MyPage(Model model, HttpSession session) {
		
		hospitalDetailService.execute(model, session);
		return "thymeleaf/medicalUser/hospitalMyPage";
	}
	
	
	@PostMapping("treatInsert")
	public String treatInsert(TreatCommand treatCommand, HttpSession session) {
		treatInsertService.execute(treatCommand);
		return "redirect:/";
	}
	
	//ajax로 웹페이지 업데이트
	
	//회원탈퇴 ajax
    @GetMapping("out.html")
    public String out(TreatCommand treatCommand, Model model, HttpSession session) {
        return "thymeleaf/medicalUser/out";
    }
    
    //병원 기본정보 ajax
    @GetMapping("baseInfo.html")
    public String baseInfo(Model model, HttpSession session) {
    	hospitalDetailService.execute(model, session);
        return "thymeleaf/medicalUser/baseInfo";
    }
    
    //비번 변경 ajax
    @GetMapping("changePw.html")
    public String changePw(Model model, HttpSession session) {
    	hospitalDetailService.execute(model, session);
        return "thymeleaf/medicalUser/changePw";
    }
    
	//기본정보 수정 ajax
    @GetMapping("baseModify.html")
    public String baseModify(HospitalCommand hospitalCommand, Model model, HttpSession session) {
    	hospitalDetailService.execute(model, session);
        return "thymeleaf/medicalUser/baseModify";
    }

}
