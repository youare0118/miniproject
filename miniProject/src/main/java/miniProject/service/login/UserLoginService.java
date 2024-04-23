package miniProject.service.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import miniProject.command.LoginCommand;
import miniProject.domain.AuthInfoDTO;

@Service
public class UserLoginService {
	public void execute(LoginCommand loginCommand, HttpSession session) {
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
	}
}
