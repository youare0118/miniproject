package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.HospitalDTO;

@Mapper
@Repository(value="miniProject.mapper.HospitalMapper")
public interface HospitalMapper {
	public void hospitalInsert(HospitalDTO dto);
	public HospitalDTO hospitalSelectOne(String hospitalNum);
	public String selectHospitalNum(String hospitalId);
}
