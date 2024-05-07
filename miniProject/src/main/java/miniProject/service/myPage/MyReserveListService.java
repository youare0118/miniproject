package miniProject.service.myPage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.ReserveDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.ReserveMapper;

@Service
public class MyReserveListService {

	@Autowired
	ReserveMapper reserveMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		List<ReserveDTO> list = reserveMapper.myReserveSelectList(auth.getUserId());
		model.addAttribute("dtos", list);
	}
}
