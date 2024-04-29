package miniProject.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import miniProject.domain.AuthInfoDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberDropService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public int execute(String memberPw, HttpSession session) {
		int i = 0;
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		System.out.println(auth.getUserId());
		if(passwordEncoder.matches(memberPw, auth.getUserPw())) {
			int y = memberMapper.memberDelete(auth.getUserId());
			if(y >0 ) i = 1; 
		}
		return i;
	}
}
