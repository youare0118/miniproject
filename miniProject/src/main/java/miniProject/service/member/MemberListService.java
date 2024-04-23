package miniProject.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.MemberDTO;
import miniProject.domain.StartEndPageDTO;
import miniProject.mapper.MemberMapper;
import miniProject.service.StartEndPageService;

@Service
public class MemberListService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	StartEndPageService startEndPageService; // paging
	
	public void execute(Model model, Integer page, String searchWord) {
		
		// paging
		Integer limit = 10; // 한 페이지에 보여줄 갯수
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		
		List<MemberDTO> list = memberMapper.memberSelectList(sepDTO);
		int count = memberMapper.memberCount();
		startEndPageService.execute(page, count, limit, model, searchWord);
		model.addAttribute("dtos", list); // 최대 10개
	}
}
