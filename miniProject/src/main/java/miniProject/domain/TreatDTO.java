package miniProject.domain;

import java.security.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("treat")
public class TreatDTO {
	String hospitalNum;
	Date treatDate;
	String treatDoctor;
	Timestamp startTime;
	Timestamp  endTime;
}
