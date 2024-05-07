package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.ReserveDTO;

@Mapper
@Repository(value="miniProject.mapper.ReserveMapper")
public interface ReserveMapper {
	public void reserveInsert(ReserveDTO dto);
	public List<ReserveDTO> myReserveSelectList(String memberNum);
}
