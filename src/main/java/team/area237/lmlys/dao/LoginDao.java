package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.response.LoginResponse;
@Mapper
@Component
public interface LoginDao {
    LoginResponse loginByColumn(@Param("column")String column, @Param("value")String value,@Param("password")String password);
}
