package miniProject.service.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.ReserveCommand;
import miniProject.mapper.AutoNumMapper;

@Service
public class ReserveAutoNumService {
	@Autowired
	AutoNumMapper autoNumMapper;
	
	public void execute(Model model) {
		String reserveNum = autoNumMapper.autoNumSelectOne("reserve1", "reserve_num", "res");
		ReserveCommand reserveCommand = new ReserveCommand();
		reserveCommand.setReserveNum(reserveNum);
		model.addAttribute("reserveCommand", reserveCommand);
	}
}
