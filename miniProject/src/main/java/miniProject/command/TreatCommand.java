package miniProject.command;


import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TreatCommand {
	String hospitalNum;
	String treatDoctor;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime monday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime monday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime tuesday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime tuesday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime wednesday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime wednesday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime thursday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime thursday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime friday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime friday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime saturday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime saturday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime sunday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime sunday_end;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime holiday_start;
	@DateTimeFormat(pattern = "hh:mm a")
	LocalTime holiday_end;
	
}
