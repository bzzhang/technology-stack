package technology.it.stack.mybatis.mapper;


import org.apache.ibatis.annotations.Param;
import technology.it.stack.mybatis.dto.UserDto;

import java.util.List;

/**
 * Created by xmf on 2016/9/7.
 */
public interface UserMapper {
	List<UserDto> selectUsers(@Param("offset") int offset, @Param("limit") int limit, @Param("name") String name);

}
