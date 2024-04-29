package miniProject.service.treat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.command.HospitalCommand;
import miniProject.command.TreatCommand;
import miniProject.domain.TreatDTO;
import miniProject.mapper.TreatMapper;

@Service
public class TreatInsertService {
	@Autowired
	TreatMapper treatMapper;
	
	public void execute(TreatCommand treatCommand) {
		TreatDTO dto = new TreatDTO();
		
		dto.setHospitalNum(treatCommand.getHospitalNum());
		dto.setTreatDate(treatCommand.getTreatDate());
		dto.setTreatDoctor(treatCommand.getTreatDoctor());
		dto.setStartTime(treatCommand.getStartTime());
		dto.setEndTime(treatCommand.getEndTime());
		
		treatMapper.treatInsert(dto);
	}
}
