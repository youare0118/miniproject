package miniProject.mapper;

import org.springframework.stereotype.Repository;

import miniProject.domain.AuthInfoDTO;

@Repository("miniProject.mapper.LoginMapper")
public interface LoginMapper {
	public String idCheckSelectOne(String userId);
	public String emailCheckSelectOne(String userEmail);
	public AuthInfoDTO loginSelect(String userId);
}
