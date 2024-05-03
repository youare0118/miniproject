package miniProject.service.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.TreatDTO;
import miniProject.mapper.TreatMapper;

@Service
public class TreatTimeSetService {

	@Autowired
	TreatMapper treatMapper;
	
	public void execute(String hospitalNum, Model model) {
		TreatDTO dto = treatMapper.treatSelectOne(hospitalNum);
		model.addAttribute("treatCommand", dto);
	}
}
