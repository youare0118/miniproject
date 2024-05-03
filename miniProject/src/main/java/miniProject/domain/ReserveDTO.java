package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("reserve")
public class ReserveDTO {
	String reserveNum;
	String hospitalNum;
	String memberNum;
	String memberName;
	String reserveDate;
	String reserveContent;
	String reserveState;
	String doctor;
}
