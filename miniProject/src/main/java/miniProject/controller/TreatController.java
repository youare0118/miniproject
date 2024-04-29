package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.command.TreatCommand;
import miniProject.service.hospital.HospitalDetailService;
import miniProject.service.treat.TreatInsertService;

@Controller
@RequestMapping("medicalUser")
public class TreatController {
	@Autowired
	HospitalDetailService hospitalDetailService;
	@Autowired
	TreatInsertService treatInsertService;
	
    @GetMapping("treatInfo.html")
    public String treatInfo(Model model, HttpSession session) {
    	hospitalDetailService.execute(model, session);
        return "thymeleaf/medicalUser/treatInfo";
    }
    @GetMapping("treatModify.html")
    public String treatModify() {
        return "thymeleaf/medicalUser/treatModify";
    }
}
