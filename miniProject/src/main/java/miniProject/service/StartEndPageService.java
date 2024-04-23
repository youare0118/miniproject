package miniProject.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.StartEndPageDTO;

@Service
public class StartEndPageService {

	public StartEndPageDTO execute(int limit, int page, String searchWord) {
		int startRow = ((page - 1) * limit) + 1; // 1p:1, 2p:11
		int endRow = startRow + limit - 1;
		StartEndPageDTO sepDTO = new StartEndPageDTO();
		sepDTO.setStartRow(startRow);
		sepDTO.setEndRow(endRow);
		sepDTO.setSearchWord(searchWord);
		return sepDTO;
	}
	
	public void execute(int page, int count, int limit, Model model, String searchWord) {
		
		int limitPage = 10;
		int startPage = (int) ((double)page / limitPage + 0.95 - 1) * limitPage + 1;
		                // 15.0 / 10.0 + 0.95 - 1 = 1.45 => 1 * 10 + 1 = 11
		                // 20.0 / 10.0 + 0.95 - 1 = 1.95 => 1 * 10 + 1 = 11
		int endPage = startPage + limitPage - 1;
		int maxPage = (int) ((double) count / limit + 0.95);
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		if(endPage == 0) {
			endPage = 1; // 회원이 없는 경우 maxPage가 0이 되어endPage가 0이 되는것을 막기 위함
		}
		model.addAttribute("searchWord", searchWord);
	    model.addAttribute("page", page);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	    model.addAttribute("count", count);
	    model.addAttribute("maxPage", maxPage);
	}
	
}
