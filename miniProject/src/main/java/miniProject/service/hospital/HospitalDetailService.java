package miniProject.service.hospital;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.AuthInfoDTO;
import miniProject.domain.HospitalDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class HospitalDetailService {
	@Autowired
	HospitalMapper hospitalMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String hospitalId = auth.getUserId();
		String hospitalNum = hospitalMapper.selectHospitalNum(hospitalId);
		
		
		HospitalDTO dto = hospitalMapper.hospitalSelectOne(hospitalNum);
		model.addAttribute("hospitalCommand", dto);
	}
}
