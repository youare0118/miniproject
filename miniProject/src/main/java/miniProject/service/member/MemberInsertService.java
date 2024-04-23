package miniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberInsertService {

	@Autowired
	PasswordEncoder passwordEncoder;	
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand) {
		
		// command의 getter 이용
		MemberDTO dto = new MemberDTO();
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberGender(memberCommand.getMemberGender());
		dto.setMemberJumin(memberCommand.getMemberJumin());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberPost(memberCommand.getMemberPost());
		
		String encoderPw = passwordEncoder.encode(memberCommand.getMemberPw());
		System.out.println(encoderPw);
		dto.setMemberPw(encoderPw);
		memberMapper.memberInsert(dto);

	}
}
