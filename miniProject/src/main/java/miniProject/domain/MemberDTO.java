package miniProject.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("member")
public class MemberDTO {

	String memberNum;
	String memberName;
	String memberId;
	String memberPw;
	Date memberBirth;
	String memberGender;
	String memberJumin;
	String memberEmail;
	String memberPhone;
	String memberAddr;
	String memberAddrDetail;	
	String memberPost;	
	String memberVip;

}
