package miniProject.service.hospital;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.HospitalCommand;
import miniProject.mapper.AutoNumMapper;

@Service
public class HospitalAutoNumService {
	@Autowired
	AutoNumMapper autoNumMapper;
	
	public void execute(Model model) {
		String hospitalNum = autoNumMapper.autoNumSelectOne("hospital", "hospital_num", "hos");
		HospitalCommand hospitalCommand = new HospitalCommand();
		hospitalCommand.setHospitalNum(hospitalNum);
		model.addAttribute("hospitalCommand", hospitalCommand);
	}
}
