package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.HospitalDTO;
import miniProject.domain.StartEndPageDTO;

@Mapper
@Repository(value="miniProject.mapper.HospitalMapper")
public interface HospitalMapper {
	public void hospitalInsert(HospitalDTO dto);
	public HospitalDTO hospitalSelectOne(String hospitalNum);
	public String selectHospitalNum(String hospitalId);
	public List<HospitalDTO> hospitalSelectList(StartEndPageDTO sepDTO);
	public Integer hospitalCount();
}
