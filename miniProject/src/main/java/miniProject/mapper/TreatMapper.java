package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.TreatDTO;

@Mapper
@Repository("miniProject.mapper.TreatMapper")
public interface TreatMapper {
	public void treatInsert(TreatDTO dto);
}
