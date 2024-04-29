package miniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.HospitalDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class MainService {
	
	@Autowired
	HospitalMapper hospitalMapper;
	
	public void execute(Model model) {
		List<HospitalDTO> list = hospitalMapper.hospitalSelectList();
		model.addAttribute("dtos", list);
	}
}
