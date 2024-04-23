package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("authInfo")
public class AuthInfoDTO {

	String userId;
	String userPw;
	String userName;
	String grade;
	String userEmail;
	String userEmailCheck;
}
