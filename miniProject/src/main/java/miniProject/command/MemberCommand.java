package miniProject.command;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {

		String memberNum;
		
		@NotEmpty(message = "이름을 입력해주세요.")
		String memberName;
		
		@NotEmpty(message = "아이디를 입력해주세요.")
		String memberId;
		
		@Pattern(regexp = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@%&-+~]).{8,12}$",message = "비밀번호를 조건에 맞게 입력해주시길 바랍니다.") // regexp : 정규표현식
		String memberPw;
		
		@NotBlank(message = "비밀번호 확인을 입력해주세요.")
		String memberPwCon;
		
		@NotNull(message = "생년월일을 입력해주세요. ")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		Date memberBirth;
		
		String memberGender;
		
		@Size(min = 13, max = 13)
		@NotBlank(message = "주민번호를 입력해주세요.")
		String memberJumin;
		
		@NotBlank(message = "이메일 형식이 맞지 않습니다.")
		String memberEmail;
		
		@Size(min = 11, max = 13)
		@NotBlank(message = "연락처를 입력해주세요.")
		String memberPhone;
		
		@NotBlank(message = "주소를 입력해주세요.")
		String memberAddr;
		
		String memberAddrDetail;
		
		String memberPost;
		
		String memberVip;
		

		public boolean isMemberPwEqualsMemberPwCon() {
			System.out.println(memberPw);
			System.out.println(memberPwCon);
			return memberPw.equals(memberPwCon);
		}
	
}
