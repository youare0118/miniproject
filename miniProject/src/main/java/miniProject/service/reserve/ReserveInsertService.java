package miniProject.service.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.HospitalCommand;
import miniProject.command.MemberCommand;
import miniProject.command.ReserveCommand;
import miniProject.domain.HospitalDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.ReserveDTO;
import miniProject.mapper.ReserveMapper;

@Service
public class ReserveInsertService {
	@Autowired
	ReserveMapper reserveMapper;
	
	public void execute(ReserveCommand reserveCommand, HospitalCommand hospitalCommand, 
						MemberCommand memberCommand, Model model) {
		ReserveDTO dto = new ReserveDTO();
		
		dto.setReserveNum(reserveCommand.getReserveNum());
		dto.setHospitalNum(hospitalCommand.getHospitalNum());		//hospital 테이블
		dto.setMemberNum(memberCommand.getMemberNum());			//MEMBER 테이블
		dto.setMemberName(memberCommand.getMemberName());			//name은 form에서 가져옴
		dto.setReserveDate(reserveCommand.getReserveDate());
		dto.setReserveContent(reserveCommand.getReserveContent());
		dto.setReserveState(reserveCommand.getReserveState());
		dto.setDoctor(reserveCommand.getDoctor());
		
		reserveMapper.reserveInsert(dto);
	}
}
