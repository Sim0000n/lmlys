package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.request.RegisterRequest;

@Mapper
@Component
public interface RegisterDao {
    String selectByUsername(@Param("username")String username);
    int addUser(@Param("username")String username, @Param("password")String password);
}
