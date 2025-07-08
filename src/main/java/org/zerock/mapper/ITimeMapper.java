package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface ITimeMapper {
	
	@Select("SELECT SYSDATE FROM dual")
	public String getTime();
	
	public String getTime2();
}
