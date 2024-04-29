package miniProject.service.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.HospitalDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class HospitalInfoService {

	@Autowired
	HospitalMapper hospitalMapper;
	public void execute(String hospitalNum, Model model) {
		HospitalDTO dto = hospitalMapper.hospitalSelectOne(hospitalNum);
		model.addAttribute("hospitalCommand", dto);
	}
}
