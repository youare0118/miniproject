package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("hospital")
public class HospitalDTO {
	String hospitalNum;
	String hospitalId;
	String hospitalPw;
	String hospitalCode;
	String hospitalName;
	Integer hospitalPost;
	String hospitalAddr;
	String hospitalAddrDetail;
	String hospitalEmail;
	String hospitalPhone;
	String hospitalContent;
	String hospitalCategory;
	String hospitalNotice;	//일단 null처리하기
	String hospitalDoctor;
	
    public void setHospitalEmail(String hospitalEmailFront, String hospitalEmailEnd) {
        this.hospitalEmail = hospitalEmailFront + "@" + hospitalEmailEnd;
    }
}
