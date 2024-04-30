package miniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.HospitalDTO;
import miniProject.domain.StartEndPageDTO;
import miniProject.mapper.HospitalMapper;

@Service
public class MainService {
	
	@Autowired
	HospitalMapper hospitalMapper;
	@Autowired
	StartEndPageService startEndPageService; // paging
	
	public void execute(Model model, Integer page, String searchWord) {
		
		// paging
		Integer limit = 10; // 한 페이지에 보여줄 갯수
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		
		List<HospitalDTO> list = hospitalMapper.hospitalSelectList(sepDTO);
		int count = hospitalMapper.hospitalCount();
		startEndPageService.execute(page, count, limit, model, searchWord);
		model.addAttribute("dtos", list);
	}
}
