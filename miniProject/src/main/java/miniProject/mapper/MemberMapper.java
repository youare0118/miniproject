package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import miniProject.domain.MemberDTO;
import miniProject.domain.StartEndPageDTO;

@Mapper
@Repository(value="miniProject.mapper.MemberMapper")
public interface MemberMapper {
	
	public List<MemberDTO> memberSelectList(StartEndPageDTO sepDTO);
	public Integer memberCount();
	public void memberInsert(MemberDTO dto);
	public MemberDTO memberSelectOne(String memberNumOrId);
	public int memberUpdate(MemberDTO dto);
	public int memberDelete(String memberNum);
	public void memberPwUpdate(@Param("memberPw") String memberPw, 
			   @Param("memberId") String memberId);
	public int memberJoinInsert(MemberDTO dto);
	public String inIdOutNum(String memberId);
}
