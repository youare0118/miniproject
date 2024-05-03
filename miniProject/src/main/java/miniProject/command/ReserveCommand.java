package miniProject.command;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReserveCommand {
	String reserveNum;
	String hospitalNum;
	String memberNum;
	String memberName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	String reserveDate;
	String reserveContent;
	String reserveState;
	String doctor;
	String reserveTime;
}
