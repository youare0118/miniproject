package miniProject.service.treat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		dto.setTreatDoctor(treatCommand.getTreatDoctor());
		dto.setMonday_start(treatCommand.getMonday_start());
		dto.setMonday_end(treatCommand.getMonday_end());
		dto.setTuesday_start(treatCommand.getTuesday_start());
		dto.setTuesday_end(treatCommand.getTuesday_end());
		dto.setWednesday_start(treatCommand.getWednesday_start());
		dto.setWednesday_end(treatCommand.getWednesday_end());
		dto.setThursday_start(treatCommand.getThursday_start());
		dto.setThursday_end(treatCommand.getThursday_end());
		dto.setFriday_start(treatCommand.getFriday_start());
		dto.setFriday_end(treatCommand.getFriday_end());
		dto.setSaturday_start(treatCommand.getSaturday_start());
		dto.setSaturday_end(treatCommand.getSaturday_end());
		dto.setSunday_start(treatCommand.getSunday_start());
		dto.setSunday_end(treatCommand.getSunday_end());
		dto.setHoliday_start(treatCommand.getHoliday_start());
		dto.setHoliday_end(treatCommand.getHoliday_end());
		
		treatMapper.treatInsert(dto);
	}
}
