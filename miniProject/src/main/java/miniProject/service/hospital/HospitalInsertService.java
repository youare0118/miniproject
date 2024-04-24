package miniProject.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.command.HospitalCommand;
import miniProject.domain.HospitalDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class HospitalInsertService {
	@Autowired
	HospitalMapper hospitalMapper;
	
	public void execute(HospitalCommand hospitalCommand) {
		HospitalDTO dto = new HospitalDTO();
		
		dto.setHospitalNum(hospitalCommand.getHospitalNum());
		dto.setHospitalId(hospitalCommand.getHospitalId());
		dto.setHospitalPw(hospitalCommand.getHospitalPw());
		dto.setHospitalName(hospitalCommand.getHospitalName());
		dto.setHospitalCode(hospitalCommand.getHospitalCode());
		dto.setHospitalAddr(hospitalCommand.getHospitalAddr());
		dto.setHospitalAddrDetail(hospitalCommand.getHospitalAddrDetail());
		dto.setHospitalPost(hospitalCommand.getHospitalPost());
		dto.setHospitalEmail(hospitalCommand.getHospitalEmailFront(), hospitalCommand.getHospitalEmailEnd());
		dto.setHospitalPhone(hospitalCommand.getHospitalPhone());
		dto.setHospitalContent(hospitalCommand.getHospitalContent());
		dto.setHospitalCategory(hospitalCommand.getHospitalCategory());
		dto.setHospitalNotice(hospitalCommand.getHospitalNotice());
		dto.setHospitalDoctor(hospitalCommand.getHospitalDoctor());
		
		hospitalMapper.hospitalInsert(dto);
	}
}
