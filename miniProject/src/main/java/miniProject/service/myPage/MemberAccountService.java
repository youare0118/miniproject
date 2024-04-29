package miniProject.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.MemberCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberAccountService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public int execute(MemberCommand memberCommand, HttpSession session, Model model) {
		
		int i = 0;
		
		// 입력한 pw
		String inputPw; 
		inputPw = memberCommand.getMemberPw();
		
		// 세션값에서 로그인한 계정의 패스워드를 가져오기 위해 선언
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		// 두개를 비교하여 일치하면 저장 아니면 에러문 반환
		if(passwordEncoder.matches(inputPw, auth.getUserPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setMemberNum(memberCommand.getMemberNum());
			dto.setMemberId(memberCommand.getMemberId());
			dto.setMemberEmail(memberCommand.getMemberEmail());
			dto.setMemberPhone(memberCommand.getMemberPhone());
			dto.setMemberPost(memberCommand.getMemberPost());
			dto.setMemberAddr(memberCommand.getMemberAddr());
			dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
			
			int y = memberMapper.memberUpdate(dto);
			if(y>0) {i = 1;}
		}
		return i;
	}
}
