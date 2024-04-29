package miniProject.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import miniProject.command.HospitalCommand;
import miniProject.domain.HospitalDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class HospitalInsertService {
	@Autowired
	HospitalMapper hospitalMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
		
		//비밀번호 암호화
		String encoderPw = passwordEncoder.encode(hospitalCommand.getHospitalPw());
		System.out.println(encoderPw);
		dto.setHospitalPw(encoderPw);

		hospitalMapper.hospitalInsert(dto);
	}
}
