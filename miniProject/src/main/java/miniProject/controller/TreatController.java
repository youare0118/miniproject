package miniProject.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.HospitalCommand;
import miniProject.service.hospital.HospitalDetailService;

@Controller
@RequestMapping("medicalUser")
public class TreatController {
	@Autowired
	HospitalDetailService hospitalDetailService;
	
    @GetMapping("treatInfo.html")
    public String treatInfo(Model model, HttpSession session) {
    	hospitalDetailService.execute(model, session);
        return "thymeleaf/medicalUser/treatInfo";
    }
}
