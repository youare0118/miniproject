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
		System.out.println("treatCommand.getFridayEnd() : " + treatCommand.getFridayEnd());
		TreatDTO dto = new TreatDTO();
		
		dto.setHospitalNum(treatCommand.getHospitalNum());
		dto.setTreatDoctor(treatCommand.getTreatDoctor());
		dto.setMondayStart(treatCommand.getMondayStart());
		dto.setMondayEnd(treatCommand.getMondayEnd());
		dto.setTuesdayStart(treatCommand.getTuesdayStart());
		dto.setTuesdayEnd(treatCommand.getTuesdayEnd());
		dto.setWednesdayStart(treatCommand.getWednesdayStart());
		dto.setWednesdayEnd(treatCommand.getWednesdayEnd());
		dto.setThursdayStart(treatCommand.getThursdayStart());
		dto.setThursdayEnd(treatCommand.getThursdayEnd());
		dto.setFridayStart(treatCommand.getFridayStart());
		dto.setFridayEnd(treatCommand.getFridayEnd());
		dto.setSaturdayStart(treatCommand.getSaturdayStart());
		dto.setSaturdayEnd(treatCommand.getSaturdayEnd());
		dto.setSundayStart(treatCommand.getSundayStart());
		dto.setSundayEnd(treatCommand.getSundayEnd());
		dto.setHolidayStart(treatCommand.getHolidayStart());
		dto.setHolidayEnd(treatCommand.getHolidayEnd());
		
		treatMapper.treatInsert(dto);
	}
}
