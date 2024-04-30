package miniProject.domain;


import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("treat")
public class TreatDTO {
	String hospitalNum;
	String treatDoctor;
	String mondayStart;
	String mondayEnd;
	String tuesdayStart;
	String tuesdayEnd;
	String wednesdayStart;
	String wednesdayEnd;
	String thursdayStart;
	String thursdayEnd;
	String fridayStart;
	String fridayEnd;
	String saturdayStart;
	String saturdayEnd;
	String sundayStart;
	String sundayEnd;
	String holidayStart;
	String holidayEnd;
	
}
