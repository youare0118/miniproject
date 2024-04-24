package miniProject.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class HospitalCommand {
	String hospitalNum;
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	String hospitalId;
	
	@Pattern(regexp = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@%&-+~]).{8,12}$",message = "비밀번호를 조건에 맞게 입력해주시길 바랍니다.")
	String hospitalPw;
	
	@NotBlank(message = "비밀번호 확인을 입력해주세요.")
	String hospitalPwCon;
	
	@NotEmpty(message = "병원코드를 입력해주세요")
	String hospitalCode;
	
	@NotEmpty(message =" 병원 이름을 입력해주세요")
	String hospitalName;
	Integer hospitalPost;
	String hospitalAddr;
	String hospitalAddrDetail;
	String hospitalEmailFront;
	String hospitalEmailEnd;
	String hospitalEmail;
	
	@NotBlank(message = "연락처를 입력해주세요")
	String hospitalPhone;
	
	String hospitalContent;
	String hospitalCategory;
	String hospitalNotice;	//일단 null처리하기
	String hospitalDoctor;
	
	public boolean isHospitalPwEqualsHospitalPwCon() {
		System.out.println(hospitalPw);
		System.out.println(hospitalPwCon);
		return hospitalPw.equals(hospitalPwCon);
	}
}
