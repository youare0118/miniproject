package miniProject.domain;

import java.time.LocalTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("treat")
public class TreatDTO {
	String hospitalNum;
	String treatDoctor;
	LocalTime monday_start;
	LocalTime monday_end;
	LocalTime tuesday_start;
	LocalTime tuesday_end;
	LocalTime wednesday_start;
	LocalTime wednesday_end;
	LocalTime thursday_start;
	LocalTime thursday_end;
	LocalTime friday_start;
	LocalTime friday_end;
	LocalTime saturday_start;
	LocalTime saturday_end;
	LocalTime sunday_start;
	LocalTime sunday_end;
	LocalTime holiday_start;
	LocalTime holiday_end;
	
}
