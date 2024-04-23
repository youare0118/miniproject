package miniProject.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("miniProject.mapper.AutoNumMapper")
public interface AutoNumMapper {
	// mybatis에서 전달되는 값이 하나 이상일 경우 @Param 사용하면 배열로 묶어 전달함
		public String autoNumSelectOne(
				@Param("tableName") String tableName
							, @Param("columnName") String columnName
								, @Param("sep") String sep);
		public void numsDelete(
				@Param("nums") String nums[]
						,@Param("tableName") String tableName
							,@Param("columnName") String columnName);
	
}
