package miniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberDeleteService {

	@Autowired 
	MemberMapper memberMapper;
	
	public void execute(String memberNum) {
		memberMapper.memberDelete(memberNum);
	}
}
