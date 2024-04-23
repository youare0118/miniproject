package miniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberUpdateService {

	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand) {
		// command의 getter 이용
		MemberDTO dto = new MemberDTO();
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPost(memberCommand.getMemberPost());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		
		memberMapper.memberUpdate(dto);
	}
}
