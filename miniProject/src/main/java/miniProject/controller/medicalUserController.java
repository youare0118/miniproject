package miniProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.HospitalCommand;
import miniProject.service.hospital.HospitalAutoNumService;
import miniProject.service.hospital.HospitalInsertService;

@Controller
@RequestMapping("medicalUser")
public class medicalUserController {
	@Autowired
	HospitalAutoNumService hospitalAutoNumService;
	@Autowired
	HospitalInsertService hospitalInsertService;
	
	@GetMapping("userWrite")
	public String userWrite(HospitalCommand hospitalCommand, Model model) {
		hospitalAutoNumService.execute(model);
		return "thymeleaf/medicalUser/medicalForm";
	}
	@PostMapping("hospitalMyPage")
	public String myPage(HospitalCommand hospitalCommand) {
		hospitalInsertService.execute(hospitalCommand);
		return "thymeleaf/medicalUser/hospitalMyPage";
	}
}
