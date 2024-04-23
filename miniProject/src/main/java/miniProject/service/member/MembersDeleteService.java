package miniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.mapper.AutoNumMapper;

@Service
public class MembersDeleteService {

	@Autowired
	AutoNumMapper autoNumMapper;
	public void execute(String memberNums []) {
		autoNumMapper.numsDelete(memberNums, "member", "member_num");
	}
}
