package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.ReserveDTO;

@Mapper
@Repository(value="miniProject.mapper.ReserveMapper")
public interface ReserveMapper {
	public void reserveInsert(ReserveDTO dto);

}
