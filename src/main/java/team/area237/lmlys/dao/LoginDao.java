package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.entity.Customer;

@Mapper
@Component
public interface LoginDao {
    Customer loginByColumn(@Param("column")String column, @Param("value")String value);
}
