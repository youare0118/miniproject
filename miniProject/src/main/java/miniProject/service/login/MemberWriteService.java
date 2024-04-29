package miniProject.service.login;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;
import miniProject.service.EmailSendService;

@Service
public class MemberWriteService {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	EmailSendService emailSendService;
	//@Autowired
	//SMSMessageService smsMessageService;
	
	public void execute(MemberCommand memberCommand,Model model) {
				
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
		dto.setMemberPw(encoderPw);
		
		int i = memberMapper.memberJoinInsert(dto); // 회원가입
		model.addAttribute("userName", dto.getMemberName());
		model.addAttribute("userEmail", dto.getMemberEmail());
		
		if(i>0) {
			String html = "<html><body>";
				   html+= dto.getMemberName() + "님의 회원가입을 축하합니다. <br/>";
				   html+= "가입을 완료하시려면 ";
				   html+= "<a href='http://localhost:8080/userConfirm?chk="+dto.getMemberEmail();
				   html+= "'> 여기</a>를 클릭하세요.";
				   html+= "</body></html>";
			String subject = "환영 인사입니다.";
			String fromEmail = "soongmoostudent@gmail.com";
			String toEmail = dto.getMemberEmail();
			emailSendService.mailsend(html, subject, fromEmail, toEmail);
		}
		
		/*
		 * // SMS String content = "안녕하세요. 한경쇼핑몰 관리자입니다. "; content +=
		 * dto.getMemberName() + "님 가입을 환영합니다."; content += "이메일에서 회원 가입 인증이 필요합니다.";
		 * smsMessageService.smsSend("010-7146-1970", dto.getMemberPhone(), content);
		 */
	}
}
