package miniProject.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import miniProject.command.UserPwCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.mapper.MemberMapper;

@Service
public class UserPasswordConfirmService {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	
	public boolean execute(UserPwCommand userPwCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(passwordEncoder.matches(userPwCommand.getOldPw(), 
				auth.getUserPw())) {
			String  userPw = passwordEncoder.encode(userPwCommand.getNewPw());
			memberMapper.memberPwUpdate(userPw, auth.getUserId());
			auth.setUserPw(userPw);
			return true;
		}else return false;
	}
	
}
