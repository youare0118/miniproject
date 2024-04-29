package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.service.reserve.HospitalInfoService;

@Controller
@RequestMapping("reserve")
public class ReserveController {

	@Autowired
	HospitalInfoService hospitalInfoService;
	
	@GetMapping("reservation/{hospitalNum}")
	public String reservationPage(@PathVariable("hospitalNum") String hospitalNum, Model model){
		hospitalInfoService.execute(hospitalNum, model);
		return "thymeleaf/reserve/reservationPage";
	}
}
