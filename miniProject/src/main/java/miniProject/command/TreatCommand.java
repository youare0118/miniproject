package miniProject.command;

import java.security.Timestamp;

import java.util.Date;

import lombok.Data;
@Data
public class TreatCommand {
	String hospitalNum;
	Date treatDate;
	String treatDoctor;
	Timestamp startTime;
	Timestamp  endTime;
}
