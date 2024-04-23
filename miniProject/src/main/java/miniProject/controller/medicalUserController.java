package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("medicalUser")
public class medicalUserController {
	@PostMapping("userWrite")
	public String userWrite() {
		return "thymeleaf/medicalUser/medicalForm";
	}
}
